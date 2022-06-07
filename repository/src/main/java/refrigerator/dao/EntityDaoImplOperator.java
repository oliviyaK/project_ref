package refrigerator.dao;

import org.hibernate.sql.Select;
import refrigerator.entity.Operator;
import refrigerator.util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class EntityDaoImplOperator extends EntityDaoImpl<Operator> {
    private static EntityManager entityManager;
    public EntityDaoImplOperator() {
        super(Operator.class);
    }

    public List<Object[]>listOfOperator(){
        entityManager = HibernateUtil.getEntityManager();
        Query query = entityManager.createQuery(
                "SELECT o.id, o.name, "+"c.name, c.surname, "
                +"r.requestType, "+"p.date "+"FROM Operator o "+
                        "join o.clientList c, o.requestList r, o.operationList p");
        List<Object[]> list = query.getResultList();
        entityManager.close();
        return list;
    }
}
