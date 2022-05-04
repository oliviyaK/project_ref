package refrigerator.dao;

import org.junit.Assert;
import org.junit.Test;
import refrigerator.entity.Detail;

import java.util.ArrayList;
import java.util.List;

import static utils.Utils.createDetail;

public class EntityDaoImplDetailTest {
    private List<Detail> details = new ArrayList<>();

    @Test
    public void testInsert() {
        Detail detail = createDetail();
        EntityDaoImplDetail dao = new EntityDaoImplDetail();
        Assert.assertNull(dao.selectById(1));
        dao.insert(detail);
        Assert.assertNotNull(dao.selectById(detail.getId()));
    }

    @Test
    public void testDeleteById() {
        Detail detail = createDetail();
        EntityDaoImplDetail dao = new EntityDaoImplDetail();
        dao.insert(detail);
        Assert.assertNotNull(dao.selectById(detail.getId()));
        dao.deleteById(detail.getId());
        Assert.assertNull(dao.selectById(detail.getId()));
    }

    @Test
    public void testUpdate() {
        Detail detail = createDetail();
        EntityDaoImplDetail dao = new EntityDaoImplDetail();
        dao.insert(detail);
        Detail detail1 = dao.selectById(detail.getId());
        detail1.setName("hh");
        dao.update(dao.selectById(detail.getId()));
        Assert.assertNotSame(detail.toString(), detail1.toString());
    }

    @Test
    public void testSelect() {
        Detail detail = createDetail();
        EntityDaoImplDetail dao = new EntityDaoImplDetail();
        dao.insert(detail);
        Detail detail1 = dao.selectById(detail.getId());
        Assert.assertEquals(detail.toString(), detail1.toString());
    }

    @Test
    public void testSelectById() {
        Detail detail = createDetail();
        EntityDaoImplDetail dao = new EntityDaoImplDetail();
        dao.insert(detail);
        details.add(detail);
        Assert.assertEquals(details.get(0).toString(), dao.selectById(detail.getId()).toString());
    }
}