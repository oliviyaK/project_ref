package refrigerator.dao;

import org.junit.Assert;
import org.junit.Test;
import refrigerator.entity.Operation;

import java.util.ArrayList;
import java.util.List;

import static utils.Utils.createOperation;

public class EntityDaoImplOperationTest {
    private List<Operation> operations = new ArrayList<>();

    @Test
    public void testInsert() {
        Operation operation = createOperation();
        EntityDaoImplOperation dao = new EntityDaoImplOperation();
        Assert.assertNull(dao.selectById(1));
        dao.insert(operation);
        Assert.assertNotNull(dao.selectById(operation.getId()));
    }

    @Test
    public void testDeleteById() {
        Operation operation = createOperation();
        EntityDaoImplOperation dao = new EntityDaoImplOperation();
        dao.insert(operation);
        Assert.assertNotNull(dao.selectById(1));
        dao.deleteById(1);
        Assert.assertNull(dao.selectById(operation.getId()));
    }

    @Test
    public void testUpdate() {
        Operation operation = createOperation();
        EntityDaoImplOperation dao = new EntityDaoImplOperation();
        dao.insert(operation);
        Operation operation1 = dao.selectById(operation.getId());
        operation.setComment("hh");
        dao.update(dao.selectById(operation.getId()));
        Assert.assertNotSame(operation.toString(), operation1.toString());
    }

    @Test
    public void testSelect() {
        Operation operation = createOperation();
        EntityDaoImplOperation dao = new EntityDaoImplOperation();
        dao.insert(operation);
        Operation operation1 = dao.selectById(operation.getId());
        Assert.assertEquals(operation.toString(), operation1.toString());
    }

    @Test
    public void testSelectById() {
        Operation operation = createOperation();
        EntityDaoImplOperation dao = new EntityDaoImplOperation();
        dao.insert(operation);
        operations.add(operation);
        Assert.assertEquals(operations.get(0).toString(), dao.selectById(operation.getId()).toString());
    }
}