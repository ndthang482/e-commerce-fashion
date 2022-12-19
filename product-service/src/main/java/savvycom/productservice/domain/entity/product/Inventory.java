package savvycom.productservice.domain.entity.product;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name ="inventory")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Schema(description = "Inventory by id")
    private Long id;

    @Schema(description = "Inventory by branchId")
    private Long branchId;

    @Schema(description = "Inventory by productId")
    private Long productId;

    @Schema(description = "Inventory by quantity")
    private Long quantity;

    @Schema(description = "Created time")
    private LocalDateTime createdAt;

    @Schema(description = "Modified time")
    private LocalDateTime modifiedAt;

}
