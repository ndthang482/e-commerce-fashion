package savvycom.productservice.domain.entity.product;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Table(name="category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Schema(description = "Category by id")
    private Long id;

    @Schema(description = "Category by name")
    private String name;

    @Schema(description = "Category by desc")
    @Column(name = "description")
    private String desc;

    @Schema(description = "Created time")
    private LocalDateTime createdAt;

    @Schema(description = "Modified time")
    private LocalDateTime modifiedAt;

}
