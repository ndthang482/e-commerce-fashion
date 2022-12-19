package savvycom.productservice.domain.entity.product;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.security.Timestamp;
import java.sql.Date;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
@Table(name="product")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Schema(description = "Product by id")
    private Long id;

    @Schema(description = "Product by color")
    private String color;

    @Schema(description = "Product by size")
    private String size;

    @Schema(description = "Product by productLineId")
    private Long productLineId;

    @Schema(description = "Product by price")
    private Long price;

    @Schema(description = "Product by active")
    private Long active;

    @Schema(description = "Created time")
    private LocalDateTime createdAt;

    @Schema(description = "Modified time")
    private LocalDateTime modifiedAt;

}