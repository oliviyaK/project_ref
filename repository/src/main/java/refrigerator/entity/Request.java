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
@Table(name = "requests")
public class Request implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "date", nullable = false)
    private String date;

    @Column(name = "type_of_request", nullable = false)
    private String requestType;

    @Column(name = "request_comment", nullable = true)
    private String comment;

    @OneToOne(mappedBy = "request")
    private Operation operation;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "client_id")
    @ToString.Exclude
    private Client client;
}
