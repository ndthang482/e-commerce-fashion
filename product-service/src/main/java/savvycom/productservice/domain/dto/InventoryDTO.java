package savvycom.productservice.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class InventoryDTO {

    @Schema(description = "Inventory By branchId")
    private Long branchId;

    @Schema(description = "Inventory By productId")
    private Long productId;

    @Schema(description = "Inventory By quantity")
    private Long quantity;
}
