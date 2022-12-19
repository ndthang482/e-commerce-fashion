package savvycom.productservice.domain.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoryDTO {

    @Schema(description = "Category id")
    private Long id;

    @Schema(description = "Category name")
    private String name;

    @Schema(description = "ProductOutput")
    private List<ProductOutput> productOutputs;

}
