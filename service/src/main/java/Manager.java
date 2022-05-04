import refrigerator.dao.*;
import refrigerator.entity.*;
import refrigerator.util.HibernateUtil;

import static utils.Utils.*;


public class Manager {
    public static void main(String[] args) {
        Refrigerator refrigerator1 = createRefrigerator1();
        Refrigerator refrigerator2 = createRefrigerator2();
        Refrigerator refrigerator3 = createRefrigerator3();

        Detail detail1 = createDetail1();
        Detail detail2 = createDetail2();
        Detail detail3 = createDetail3();

        Client client1 = createClient1();
        Client client2 = createClient2();

        Request request1 = createRequest1();
        Request request2 = createRequest2();
        Request request3 = createRequest3();

        Operation operation1 = createOperation1();
        Operation operation2 = createOperation2();
        Operation operation3 = createOperation3();

        EntityDaoImplClient daoImplClient = new EntityDaoImplClient();
        daoImplClient.insert(client1);
        daoImplClient.insert(client2);

        EntityDaoImplRequest daoImplRequest = new EntityDaoImplRequest();
        daoImplRequest.insert(request1);
        daoImplRequest.insert(request2);
        daoImplRequest.insert(request3);

        request1.setClient(daoImplClient.selectById(1));
        daoImplRequest.update(request1);
        request2.setClient(daoImplClient.selectById(1));
        daoImplRequest.update(request2);
        request3.setClient(daoImplClient.selectById(2));
        daoImplRequest.update(request3);

        EntityDaoImplOperation daoImplOperation = new EntityDaoImplOperation();
        daoImplOperation.insert(operation1);
        daoImplOperation.insert(operation2);
        daoImplOperation.insert(operation3);

        operation1.setRequest(daoImplRequest.selectById(1));
        daoImplOperation.update(operation1);
        operation2.setRequest(daoImplRequest.selectById(2));
        daoImplOperation.update(operation2);
        operation3.setRequest(daoImplRequest.selectById(3));
        daoImplOperation.update(operation3);


        EntityDaoImplDetail daoImplDetail = new EntityDaoImplDetail();
        daoImplDetail.insert(detail1);
        daoImplDetail.insert(detail2);
        daoImplDetail.insert(detail3);

        EntityDaoImplRefrigerator daoImplRefrigerator = new EntityDaoImplRefrigerator();
        daoImplRefrigerator.insert(refrigerator1);
        daoImplRefrigerator.insert(refrigerator2);
        daoImplRefrigerator.insert(refrigerator3);

        detail1.setRefrigerator(daoImplRefrigerator.selectById(1));
        daoImplDetail.update(detail1);
        detail2.setRefrigerator(daoImplRefrigerator.selectById(2));
        daoImplDetail.update(detail2);
        detail3.setRefrigerator(daoImplRefrigerator.selectById(3));
        daoImplDetail.update(detail3);

        HibernateUtil.close();
    }
}
