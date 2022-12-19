package savvycom.productservice.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import savvycom.productservice.domain.entity.Branch;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class InventoryOutput {

    @Schema(description = "Inventory By branchId")
    private Branch branch;

    @Schema(description = "Inventory By quantity")
    private Long quantity;
}
