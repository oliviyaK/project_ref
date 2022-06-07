package refrigerator.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface EntityDao {

    <T> void insert(T object);

    void deleteById(Integer id) throws InvocationTargetException,
            NoSuchMethodException, IllegalAccessException;

    <T> void update(T object);

    List select();

    <T> T selectById(Integer id);
    void closeDao();
}

