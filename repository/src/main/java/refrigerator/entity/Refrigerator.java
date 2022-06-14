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
@Table(name = "refrigerators")
public class Refrigerator implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "refrigerator_brand", nullable = false)
    private String brand;

    @Column(name = "brand_model")
    private String model;

    @Column(name = "refrigerator_comment")
    private String comment;

    @OneToMany(mappedBy = "refrigerator")
    @ToString.Exclude
    @Builder.Default
    private List<Detail> detailList = new ArrayList<>();

    @ManyToMany (mappedBy = "refrigerator", fetch = FetchType.EAGER)
    @ToString.Exclude
    @Builder.Default
    private List<Request> request = new ArrayList<>();
}
