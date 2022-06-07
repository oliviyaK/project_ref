package refrigerator.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

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

    @OneToOne(mappedBy = "request")
    private Operation operation;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    @ToString.Exclude
    private Client client;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "request_refrigerator",
            joinColumns = {@JoinColumn(name = "id_request")},
            inverseJoinColumns = {@JoinColumn(name = "id_refrigerator")}
    )
    @Builder.Default
    private Set<Refrigerator> refrigerators = new HashSet<>();


}
