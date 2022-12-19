package savvycom.productservice.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import savvycom.productservice.domain.entity.Image;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateProductDTO {

    @Schema(description = "ProductLine by id")
    private Long productLineId;

    @Schema(description = "ProductLine by name")
    private String name;

    @Schema(description = "ProductLine by desc")
    private String desc;

    @Schema(description = "ProductLine by categoryId")
    private Long categoryId;

    @Schema(description = "Product by id")
    private Long productId;

    @Schema(description = "Product by color")
    private String color;

    @Schema(description = "Product by size")
    private String size;

    @Schema(description = "Product by url")
    private String url;

    @Schema(description = "Product by quantity")
    private Long quantity;

    @Schema(description = "Product by price")
    private Long price;
}
