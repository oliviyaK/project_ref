package DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import refrigerator.entity.Operation;
import refrigerator.entity.Request;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientDTO {
    private Integer id;
    private String name;
    private String surname;
    private String address;
    private String phone;
    private String comment;
    private String requestOfClientDate;
    private String requestOfClientType;
    private String operationInfo;
}
