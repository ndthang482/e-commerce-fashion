package savvycom.productservice.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import savvycom.productservice.domain.entity.Discount;
import savvycom.productservice.domain.entity.Image;
import savvycom.productservice.domain.entity.product.Category;
import savvycom.productservice.domain.entity.product.Inventory;
import savvycom.productservice.domain.entity.product.ProductLine;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductOutput {

    @Schema(description = "Product line by categoryId")
    private Category category;

    @Schema(description = "Product by id")
    private Long id;

    @Schema(description = "Product by color")
    private String color;

    @Schema(description = "Product by size")
    private String size;

    @Schema(description = "Product by productLine")
    private ProductLine productLine;

    @Schema(description = "Product by price")
    private Long price;

    @Schema(description = "List Image by productId")
    private List<Image> images;

    @Schema(description = "List InventoryOutput by id")
    private List<InventoryOutput> inventories;

    @Schema(description = "Product by active")
    private Long active;

    @Schema(description = "Created time")
    private LocalDateTime createdAt;

    @Schema(description = "Modified time")
    private LocalDateTime modifiedAt;
}
