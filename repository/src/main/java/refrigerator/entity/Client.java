package refrigerator.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "clients")
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "phone_number", nullable = false)
    private String phone;

    @Column(name = "client_comment", nullable =true)
    private String comment;

    @OneToMany(mappedBy = "client")
    @ToString.Exclude
    @Builder.Default
    private List<Request> requestOfClient = new ArrayList<>();

    @OneToMany(mappedBy = "client")
    @ToString.Exclude
    @Builder.Default
    private List<Operation> operation = new ArrayList<>();

}
