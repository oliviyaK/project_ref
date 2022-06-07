package management.implementation;

import management.interfaces.OperatorService;
import refrigerator.dao.*;
import refrigerator.entity.*;

import java.util.List;

public class OperatorServiceImpl implements OperatorService {
    private final EntityDaoImplClient daoImplClient = new EntityDaoImplClient();
    private final EntityDaoImplRefrigerator daoImplRefrigerator = new EntityDaoImplRefrigerator();
    private final EntityDaoImplDetail daoImplDetail = new EntityDaoImplDetail();
    private final EntityDaoImplRequest daoImplRequest = new EntityDaoImplRequest();
    private final EntityDaoImplOperation daoImplOperation = new EntityDaoImplOperation();

    @Override
    public Refrigerator addRefrigerator(String brand, String model, String comment) {
        Refrigerator refrigerator = Refrigerator.builder()
                .brand(brand)
                .model(model)
                .comment(comment)
                .build();
        daoImplRefrigerator.insert(refrigerator);
        daoImplRefrigerator.closeDao();
        return refrigerator;

    }

    @Override
    public void updateRefrigerator(int id, String brand, String model, String comment) {
        Refrigerator refrigerator = Refrigerator.builder()
                .brand(brand)
                .model(model)
                .comment(comment)
                .build();
        daoImplRefrigerator.update(refrigerator);
        daoImplRefrigerator.closeDao();
    }

    @Override
    public void deleteRefrigerator(Integer id) {
        daoImplRefrigerator.deleteById(id);
        daoImplRefrigerator.closeDao();
    }

    @Override
    public List<Refrigerator> findAllRefrigerators() {
        List<Refrigerator> select = daoImplRefrigerator.select();
        daoImplRefrigerator.closeDao();
        return select;
    }

    @Override
    public Refrigerator findRefrigeratorById(int id) {
        Refrigerator refrigerator = daoImplRefrigerator.selectById(id);
        daoImplRefrigerator.closeDao();
        return refrigerator;
    }

    @Override
    public Detail addDetail(String name, String price) {
        Detail detail = Detail.builder()
                .name(name)
                .price(price)
                .build();
        daoImplDetail.insert(detail);
        daoImplDetail.closeDao();
        return detail;
    }

    @Override
    public void updateDetail(String name, String price) {
        Detail detail = Detail.builder()
                .name(name)
                .price(price)
                .build();
        daoImplDetail.update(detail);
        daoImplDetail.closeDao();
    }

    @Override
    public void deleteDetail(Integer id) {
        daoImplDetail.deleteById(id);
        daoImplDetail.closeDao();
    }

    @Override
    public List<Detail> findAllDetails() {
        List<Detail> select = daoImplDetail.select();
        daoImplDetail.closeDao();
        return select;
    }

    @Override
    public Detail findDetailById(int id) {
        Detail detail = daoImplDetail.selectById(id);
        daoImplDetail.closeDao();
        return detail;
    }

    @Override
    public Request addRequest(String date, String requestType) {
        Request request = Request.builder()
                .date(date)
                .requestType(requestType)
                .build();
        daoImplRequest.insert(request);
        daoImplRequest.closeDao();
        return request;
    }

    @Override
    public void updateRequest(int id, String date, String requestType) {
        Request request = Request.builder()
                .id(id)
                .date(date)
                .requestType(requestType)
                .build();
        daoImplRequest.update(request);
        daoImplRequest.closeDao();
    }

    @Override
    public void deleteRequest(Integer id) {
        daoImplRequest.deleteById(id);
        daoImplRequest.closeDao();
    }

    @Override
    public List<Request> findAllRequests() {
        List<Request> select = daoImplRequest.select();
        daoImplRequest.closeDao();
        return select;
    }

    @Override
    public Request searchInRequests(int id) {
        Request request = daoImplClient.searchInRequests(id);
        daoImplClient.closeDao();
        return request;
    }

    @Override
    public void addRequestToClient(int id, String date, String requestType) {
        Client client = daoImplClient.selectById(id);
        Request request = Request.builder()
                .id(id)
                .date(date)
                .requestType(requestType)
                .build();
        daoImplRequest.insert(request);
        request.setClient(daoImplClient.selectById(id));
//        client.getRequestList().add(request);
//        daoImplClient.update(client);
        daoImplRequest.update(request);
        daoImplRequest.closeDao();
        daoImplClient.closeDao();
    }

    @Override
    public Operation addOperation(String date, String comment) {
        Operation operation = Operation.builder()
                .date(date)
                .comment(comment)
                .build();
        daoImplOperation.insert(operation);
        return operation;
    }

    @Override
    public void updateOperation(int id, String date, String comment) {
        Operation operation = Operation.builder()
                .date(date)
                .comment(comment)
                .build();
        daoImplOperation.update(operation);
        daoImplOperation.closeDao();
    }

    @Override
    public void deleteOperation(Integer id) {
        daoImplOperation.deleteById(id);
        daoImplOperation.closeDao();
    }

    @Override
    public List<Operation> findAllOperations() {
        List<Operation> select = daoImplOperation.select();
        daoImplOperation.closeDao();
        return select;
    }

    @Override
    public Operation findOperationById(int id) {
        Operation operation = daoImplOperation.selectById(id);
        daoImplOperation.closeDao();
        return operation;
    }

    @Override
    public Client clientCreation(String name, String surname, String address, String phone, String comment) {
        Client client = Client.builder()
                .name(name)
                .surname(surname)
                .address(address)
                .phone(phone)
                .comment(comment)
                .build();
        daoImplClient.insert(client);
        daoImplClient.closeDao();
        return client;
    }

    @Override
    public void updateClient(int id, String name, String surname, String address, String phone, String comment) {
        Client client = Client.builder()
                .id(id)
                .name(name)
                .surname(surname)
                .address(address)
                .phone(phone)
                .comment(comment)
                .build();
        daoImplClient.update(client);
        daoImplClient.closeDao();
    }

    @Override
    public List<Client> findAllClients() {
        List<Client> select = daoImplClient.select();
        daoImplClient.closeDao();
        return select;
    }

    @Override
    public Client findClientById(int id) {
        Client client = daoImplClient.selectById(id);
        daoImplClient.closeDao();
        return client;
    }

    @Override
    public void deleteClientsById(int id) {
        daoImplClient.deleteById(id);
        daoImplClient.closeDao();
    }
}
