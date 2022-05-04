package refrigerator.dao;

import org.junit.Assert;
import org.junit.Test;
import refrigerator.entity.Request;

import java.util.ArrayList;
import java.util.List;

import static utils.Utils.createRequest;

public class EntityDaoImplRequestTest {
    private List<Request> requests = new ArrayList<>();

    @Test
    public void testInsert() {
        Request request = createRequest();
        EntityDaoImplRequest dao = new EntityDaoImplRequest();
        Assert.assertNull(dao.selectById(1));
        dao.insert(request);
        Assert.assertNotNull(dao.selectById(request.getId()));
    }

    @Test
    public void testDeleteById() {
        Request request = createRequest();
        EntityDaoImplRequest dao = new EntityDaoImplRequest();
        dao.insert(request);
        Assert.assertNotNull(dao.selectById(1));
        dao.deleteById(1);
        Assert.assertNull(dao.selectById(request.getId()));
    }

    @Test
    public void testUpdate() {
        Request request = createRequest();
        EntityDaoImplRequest dao = new EntityDaoImplRequest();
        dao.insert(request);
        Request request1 = dao.selectById(request.getId());
        request.setRequestType("hh");
        dao.update(dao.selectById(request.getId()));
        Assert.assertNotSame(request.toString(), request1.toString());
    }

    @Test
    public void testSelect() {
        Request request = createRequest();
        EntityDaoImplRequest dao = new EntityDaoImplRequest();
        dao.insert(request);
        Request request1 = dao.selectById(request.getId());
        Assert.assertEquals(request.toString(), request1.toString());
    }

    @Test
    public void testSelectById() {
        Request request = createRequest();
        EntityDaoImplRequest dao = new EntityDaoImplRequest();
        dao.insert(request);
        requests.add(request);
        Assert.assertEquals(requests.get(0).toString(), dao.selectById(request.getId()).toString());
    }
}