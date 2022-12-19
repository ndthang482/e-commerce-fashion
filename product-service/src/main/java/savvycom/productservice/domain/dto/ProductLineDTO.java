package savvycom.productservice.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductLineDTO {

    @Schema(description = "Product line id")
    private Long id;

    @Schema(description = "Product line name")
    private String name;

    @Schema(description = "Product line desc")
    private String desc;

    @Schema(description = "Product line categoryId")
    private Long categoryId;

    @Schema(description = "ProductDTO")
    private List<ProductDTO> productDTOs;
}
