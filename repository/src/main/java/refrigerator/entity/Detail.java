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
@Table(name = "repair_details")
public class Detail implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "part_name", nullable = false)
    private String name;

    @Column(name = "part_price", nullable = false)
    private String price;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "refrigerator_id")
    @ToString.Exclude
    private Refrigerator refrigerator;


}
