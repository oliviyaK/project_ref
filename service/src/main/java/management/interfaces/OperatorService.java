package management.interfaces;

import DTO.ClientDTO;
import DTO.RefrigeratorDTO;
import DTO.RequestDTO;
import refrigerator.entity.*;

import java.util.List;

public interface OperatorService {
    Refrigerator addRefrigerator(String brand, String model,
                                 String comment);

    void updateRefrigerator(int id, String brand, String model,
                            String comment);

    void deleteRefrigerator(Integer id);

    List<RefrigeratorDTO> findAllRefrigerators();

    Refrigerator findRefrigeratorById(int id);

    void addRefrigeratorsToRequest(int id, String brand, String model, String comment);

    Detail addDetail(String name, String price);

    void updateDetail(int id,String name, String price);

    void deleteDetail(Integer id);

    List<Detail> findAllDetails();

    Detail findDetailById(int id);

    void addPartToRefrigerator(int id, String name, String price);

    Client clientCreation(String name, String surname, String address, String phone, String comment);

    void updateClient(int id, String name, String surname, String address, String phone, String comment);

    void deleteClientsById(int id);

    List<ClientDTO> findAllClients();

    Client findClientById(int id);

    Request addRequest(String date, String requestType);

    void updateRequest(int id, String date, String requestType);

    void deleteRequest(Integer id);

    List<RequestDTO> findAllRequests();

//    Request searchInRequests(int id);

    void addRequestToClient (int id, String date, String requestType);

    Operation addOperation(String date, String comment);

    void updateOperation(int id, String date, String comment);

    void deleteOperation(Integer id);

    List<Operation> findAllOperations();

    Operation findOperationById(int id);


}
