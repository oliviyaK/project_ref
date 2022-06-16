package refrigerator.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
@EqualsAndHashCode
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "operations")
public class Operation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "final_date", nullable = false)
    private String date;

    @Column(name = "final_comment")
    private String comment;

    @Column(name = "operation_price")
    private String operationPrice;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "request_id")
    @ToString.Exclude
    private Request request;
}
