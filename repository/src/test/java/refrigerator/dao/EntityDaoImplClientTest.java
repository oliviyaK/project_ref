package refrigerator.dao;

import org.junit.Assert;
import org.junit.Test;
import refrigerator.entity.Client;
import utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class EntityDaoImplClientTest {
    private List<Client> clients = new ArrayList<>();

    @Test
    public void testInsert() {
        Client client = Utils.createClient();
        EntityDaoImplClient dao = new EntityDaoImplClient();
        Assert.assertNull(dao.selectById(1));
        dao.insert(client);
        Assert.assertNotNull(dao.selectById(client.getId()));
    }

    @Test
    public void testDeleteById() {
        Client client = Utils.createClient();
        EntityDaoImplClient dao = new EntityDaoImplClient();
        dao.insert(client);
        Assert.assertNotNull(dao.selectById(client.getId()));
        dao.deleteById(client.getId());
        Assert.assertNull(dao.selectById(client.getId()));
    }

    @Test
    public void testUpdate() {
        Client client = Utils.createClient();
        EntityDaoImplClient dao = new EntityDaoImplClient();
        dao.insert(client);
        Client client1 = dao.selectById(client.getId());
        client1.setAddress("hh");
        dao.update(dao.selectById(client.getId()));
        Assert.assertNotSame(client.toString(), client1.toString());
    }

    @Test
    public void testSelect() {
        Client client = Utils.createClient();
        EntityDaoImplClient dao = new EntityDaoImplClient();
        dao.insert(client);
        Client client1 = dao.selectById(client.getId());
        Assert.assertEquals(client.toString(), client1.toString());
    }

    @Test
    public void testSelectById() {
        Client client = Utils.createClient();
        EntityDaoImplClient dao = new EntityDaoImplClient();
        dao.insert(client);
        clients.add(client);
        Assert.assertEquals(clients.get(0).toString(), dao.selectById(client.getId()).toString());
    }
}