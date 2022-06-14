package DTO;

import lombok.*;
import refrigerator.entity.Detail;
import refrigerator.entity.Request;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RefrigeratorDTO {
    private Integer id;
    private String brand;
    private String model;
    private String comment;
    private List<Detail> detailList;
    private List<Request> requests;
}
