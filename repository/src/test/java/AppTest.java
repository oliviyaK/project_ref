import org.junit.AfterClass;
import refrigerator.util.HibernateUtil;

public class AppTest {
    @AfterClass
    public static void clean() {
        HibernateUtil.close();
    }
}
