package refrigerator.dao;

import org.junit.Assert;
import org.junit.Test;
import refrigerator.entity.Refrigerator;

import java.util.ArrayList;
import java.util.List;

import static utils.Utils.createRefrigerator;

public class EntityDaoImplRefrigeratorTest {
    private List<Refrigerator> refrigerators = new ArrayList<>();

    @Test
    public void testInsert() {
        Refrigerator refrigerator = createRefrigerator();
        EntityDaoImplRefrigerator dao = new EntityDaoImplRefrigerator();
        Assert.assertNull(dao.selectById(1));
        dao.insert(refrigerator);
        Assert.assertNotNull(dao.selectById(refrigerator.getId()));
    }

    @Test
    public void testDeleteById() {
        Refrigerator refrigerator = createRefrigerator();
        EntityDaoImplRefrigerator dao = new EntityDaoImplRefrigerator();
        dao.insert(refrigerator);
        Assert.assertNotNull(dao.selectById(1));
        dao.deleteById(refrigerator.getId());
        Assert.assertNull(dao.selectById(refrigerator.getId()));
    }

    @Test
    public void testUpdate() {
        Refrigerator refrigerator = createRefrigerator();
        EntityDaoImplRefrigerator dao = new EntityDaoImplRefrigerator();
        dao.insert(refrigerator);
        Refrigerator refrigerator1 = dao.selectById(refrigerator.getId());
        refrigerator.setBrand("hh");
        dao.update(dao.selectById(refrigerator.getId()));
        Assert.assertNotSame(refrigerator.toString(), refrigerator1.toString());
    }

    @Test
    public void testSelect() {
        Refrigerator refrigerator = createRefrigerator();
        EntityDaoImplRefrigerator dao = new EntityDaoImplRefrigerator();
        dao.insert(refrigerator);
        Refrigerator refrigerator1 = dao.selectById(refrigerator.getId());
        Assert.assertEquals(refrigerator.toString(), refrigerator1.toString());
    }

    @Test
    public void testSelectById() {
        Refrigerator refrigerator = createRefrigerator();
        EntityDaoImplRefrigerator dao = new EntityDaoImplRefrigerator();
        dao.insert(refrigerator);
        refrigerators.add(refrigerator);
        Assert.assertEquals(refrigerators.get(0).toString(), dao.selectById(refrigerator.getId()).toString());
    }
}