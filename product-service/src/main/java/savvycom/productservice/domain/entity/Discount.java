package savvycom.productservice.domain.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name="discount")
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String name;

    @Column(name = "description")
    private String desc;

    private String discountPercent;

    private Long active;

    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;

}
