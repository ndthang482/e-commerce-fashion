package savvycom.productservice.domain.entity.product;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.security.Timestamp;
import java.sql.Date;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name="product_line")
public class ProductLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Schema(description = "ProductLine by id")
    private Long id;

    @Schema(description = "ProductLine by name")
    private String name;

    @Schema(description = "ProductLine by desc")
    @Column(name = "description")
    private String desc;

    @Schema(description = "ProductLine by categoryId")
    private Long categoryId;

    @Schema(description = "ProductLine by active")
    private Long active;

    @Schema(description = "Created time")
    private LocalDateTime createdAt;

    @Schema(description = "Modified time")
    private LocalDateTime modifiedAt;
}
