package savvycom.productservice.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoryOutput {

    @Schema(description = "Category id")
    private Long id;

    @Schema(description = "Category name")
    private String name;

    @Schema(description = "Category desc")
    private String desc;

    @Schema(description = "Created time")
    private LocalDateTime createdAt;

    @Schema(description = "modified time")
    private LocalDateTime modifiedAt;
}
