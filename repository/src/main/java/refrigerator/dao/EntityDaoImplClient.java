package refrigerator.dao;

import refrigerator.entity.Client;
import refrigerator.entity.Request;
import refrigerator.util.HibernateUtil;

import javax.persistence.EntityManager;

public class EntityDaoImplClient extends EntityDaoImpl<Client>{
    public EntityDaoImplClient() {
        super(Client.class);
    }

    }

