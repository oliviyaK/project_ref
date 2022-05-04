package refrigerator.dao;

import refrigerator.util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;


public class EntityDaoImpl<T> implements EntityDao {

    private EntityManager em;
    private final Class<T> tClass;

    public EntityDaoImpl(Class<T> tClass) {
        this.tClass = tClass;
    }

    @Override
    public <T> void insert(T object) {
        em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("This object can`t be added");
        } finally {
            em.close();
        }
    }

    @Override
    public void deleteById(Integer id) {
        em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            em.remove(em.find(tClass, id));
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("This element is absent in table or has connections with other tables.");
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    @Override
    public <T> void update(T object) {
        em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            em.merge(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("This object can`t be updated.");
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    @Override
    public List<T> select() {
        em = HibernateUtil.getEntityManager();
        String queryString = "SELECT e FROM " + tClass.getSimpleName() + " e";
        Query query = em.createQuery(queryString);
        List list = query.getResultList();
        list.forEach(System.out::println);
        em.close();
        return list;
    }

      @Override
    public <T> T selectById(Integer id) {
        em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        T obj = (T) em.find(tClass, id);
        em.getTransaction().commit();
        em.close();
        return obj;
    }
}
