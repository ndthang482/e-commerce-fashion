package savvycom.productservice.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import savvycom.productservice.domain.entity.product.Product;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateProductDTO {
    @Schema(description = "Name product line")
    private String name;

    @Schema(description = "Product line desc")
    private String desc;

    @Schema(description = "Product line categoryId")
    private Long categoryId;

    @Schema(description = "ProductInputDTO")
    private List<ProductInputDTO> options;
}
