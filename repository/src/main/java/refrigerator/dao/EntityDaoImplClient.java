package refrigerator.dao;

import refrigerator.entity.Client;
import refrigerator.entity.Request;
import refrigerator.util.HibernateUtil;

import javax.persistence.EntityManager;

public class EntityDaoImplClient extends EntityDaoImpl<Client>{
    public EntityDaoImplClient() {
        super(Client.class);
    }

    public Request searchInRequests (int id) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        Request requestToFind = null;
        try {
            entityManager.getTransaction().begin();
            requestToFind = entityManager.find(Request.class, id);
            entityManager.getTransaction().rollback();
        } finally
            {
                entityManager.close();
            }
            return requestToFind;
        }
    }

