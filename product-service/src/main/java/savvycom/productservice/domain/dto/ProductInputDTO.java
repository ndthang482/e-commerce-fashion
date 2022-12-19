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
public class ProductInputDTO {
    @Schema(description = "Product by color")
    private String color;

    @Schema(description = "Product by color")
    private String size;

    @Schema(description = "Product by price")
    private Long price;

    @Schema(description = "List image")
    private List<String> images;

    @Schema(description = "quantity product")
    private Long quantity;
}
