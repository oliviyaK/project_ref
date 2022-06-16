package management.implementation;

import DTO.ClientDTO;
import DTO.RefrigeratorDTO;
import DTO.RequestDTO;
import management.interfaces.OperatorService;
import refrigerator.dao.*;
import refrigerator.entity.*;

import java.util.List;
import java.util.stream.Collectors;

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
                .id(id)
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
    public List<RefrigeratorDTO> findAllRefrigerators() {
        List<Refrigerator> select = daoImplRefrigerator.select();
        List<RefrigeratorDTO> refrigeratorDTOS = select.stream().map(refrigerator -> RefrigeratorDTO.builder()
                        .id(refrigerator.getId())
                        .brand(refrigerator.getBrand())
                        .model(refrigerator.getModel())
                        .comment(refrigerator.getComment())
                        .detailName(refrigerator.getDetailList().stream().map(Detail::getName).collect(Collectors.joining(", ")))
                        .build())
                .collect(Collectors.toList());
        daoImplRefrigerator.closeDao();
        return refrigeratorDTOS;
    }

    @Override
    public Refrigerator findRefrigeratorById(int id) {
        Refrigerator refrigerator = daoImplRefrigerator.selectById(id);
        daoImplRefrigerator.closeDao();
        return refrigerator;
    }

    @Override
    public void addRefrigeratorsToRequest(int id, String brand, String model, String comment) {
        Request request = daoImplRequest.selectById(id);
        Refrigerator refrigerator = Refrigerator.builder()
                .brand(brand)
                .model(model)
                .comment(comment)
                .build();
        request.getRefrigerator().add(refrigerator);
        daoImplRequest.update(request);
        daoImplRequest.closeDao();
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
    public void updateDetail(int id, String name, String price) {
        Detail detail = Detail.builder()
                .id(id)
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
    public void addPartToRefrigerator(int id, String name, String price) {
        Refrigerator refrigerator = daoImplRefrigerator.selectById(id);
        Detail part = Detail.builder()
                .name(name)
                .price(price)
                .build();
        daoImplDetail.insert(part);
        part.setRefrigerator(daoImplRefrigerator.selectById(id));
        daoImplDetail.update(part);
        daoImplDetail.closeDao();
        daoImplRefrigerator.closeDao();
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
    public List<RequestDTO> findAllRequests() {
        List<Request> select = daoImplRequest.select();
        List<RequestDTO> requestDTOS = select.stream().map(request -> RequestDTO.builder()
                        .id(request.getId())
                        .date(request.getDate())
                        .requestType(request.getRequestType())
                        .refrigeratorBrand(request.getRefrigerator().stream().map(Refrigerator::getBrand).collect(Collectors.joining(", ")))
                        .refrigeratorModel(request.getRefrigerator().stream().map(Refrigerator::getModel).collect(Collectors.joining(", ")))
                        .build())
                .collect(Collectors.toList());
        daoImplRequest.closeDao();
        return requestDTOS;
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
    public List<ClientDTO> findAllClients() {
        List<Client> select = daoImplClient.select();
        List<ClientDTO> clientDTOS = select.stream().map(client -> ClientDTO.builder()
                        .id(client.getId())
                        .name(client.getName())
                        .surname(client.getSurname())
                        .phone(client.getPhone())
                        .address(client.getAddress())
                        .comment(client.getComment())
                        .requestOfClientDate(client.getRequestOfClient().stream().map(Request::getDate).collect(Collectors.joining(", ")))
                        .requestOfClientType(client.getRequestOfClient().stream().map(Request::getRequestType).collect(Collectors.joining(", ")))
                        .build())
                .collect(Collectors.toList());
        daoImplClient.closeDao();
        return clientDTOS;
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
