package DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import refrigerator.entity.Client;
import refrigerator.entity.Operation;
import refrigerator.entity.Refrigerator;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestDTO {
    private int id;
    private String date;
    private String requestType;
    private String operationOfClient;
    private Client client;
    private String refrigeratorBrand;
    private String refrigeratorModel;

}
