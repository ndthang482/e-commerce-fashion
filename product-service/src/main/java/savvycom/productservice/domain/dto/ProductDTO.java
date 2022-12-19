package savvycom.productservice.domain.dto;
// find product detail
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import savvycom.productservice.domain.entity.Discount;
import savvycom.productservice.domain.entity.Image;
import savvycom.productservice.domain.entity.Review;
import savvycom.productservice.domain.entity.product.Inventory;
import savvycom.productservice.domain.entity.product.ProductLine;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductDTO {
    @Schema(description = "Product by id")
    private Long id;

    @Schema(description = "Product by color")
    private String color;

    @Schema(description = "Product by size")
    private String size;

    @Schema(description = "Product by price")
    private Long price;

    @Schema(description = "List image by productId")
    private List<Image> images;

    @Schema(description = "List review by productId")
    private List<Review> review;

    @Schema(description = "List inventory by productId")
    private List<InventoryOutput> inventories;

    @Schema(description = "Product by active")
    private Long active;

    @Schema(description = "Created time")
    private LocalDateTime createdAt;

    @Schema(description = "Modified time")
    private LocalDateTime modifiedAt;
}
