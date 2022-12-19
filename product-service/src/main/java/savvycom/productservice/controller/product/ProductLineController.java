package savvycom.productservice.controller.product;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import savvycom.productservice.common.Const;
import savvycom.productservice.controller.BaseController;
import savvycom.productservice.domain.dto.CreateProductDTO;
import savvycom.productservice.domain.dto.UpdateProductDTO;
import savvycom.productservice.domain.entity.product.ProductLine;
import savvycom.productservice.domain.message.ResponseMessage;
import savvycom.productservice.service.product.IProductLineService;
import savvycom.productservice.service.product.IProductService;
@RequiredArgsConstructor
@RestController
@RequestMapping("/line")
public class ProductLineController extends BaseController {
    private final IProductLineService productLineService;

    /**
     * Find product detail
     * @return successResponse
     */
    @GetMapping("/{id}")
    @Operation(summary = "Find productLine by id")
    @ApiResponse(responseCode = Const.API_RESPONSE.API_STATUS_OK_STR, description = "Find product_Line by id completed",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = ResponseMessage.class))})
    @ApiResponse(responseCode = Const.API_RESPONSE.API_STATUS_BAD_REQUEST_STR, description = "Input invalid",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = ResponseMessage.class))})
    @ApiResponse(responseCode = Const.API_RESPONSE.API_STATUS_INTERNAL_SERVER_ERROR_STR, description = "Internal Server Error",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = ResponseMessage.class))})
    public ResponseEntity<?> findDetailById(@PathVariable Long id) {
        return successResponse(productLineService.findById(id));
    }
    /**
     * Create productDTO
     * @return successResponse
     */
    @PostMapping("")
//    @PreAuthorize("hasAuthority('admin')")
    @Operation(summary = "Create new ProductDTO")
    @ApiResponse(responseCode = Const.API_RESPONSE.API_STATUS_OK_STR, description = "Create new productDTO completed",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = ResponseMessage.class))})
    @ApiResponse(responseCode = Const.API_RESPONSE.API_STATUS_BAD_REQUEST_STR, description = "Input invalid",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = ResponseMessage.class))})
    @ApiResponse(responseCode = Const.API_RESPONSE.API_STATUS_INTERNAL_SERVER_ERROR_STR, description = "Internal Server Error",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = ResponseMessage.class))})
    public ResponseEntity<?> createProductDTO(@RequestBody CreateProductDTO createProductDTO){
        productLineService.createProductDTO(createProductDTO);
        return successResponse("Create new ProductDTO successfully");
    }
    /**
     * Update productDTO
     * @return successResponse
     */
    @PutMapping("/{id}")
//    @PreAuthorize("hasAuthority('admin')")
    @Operation(summary = "Update ProductDTO")
    @ApiResponse(responseCode = Const.API_RESPONSE.API_STATUS_OK_STR, description = "Update productDTO completed",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = ResponseMessage.class))})
    @ApiResponse(responseCode = Const.API_RESPONSE.API_STATUS_BAD_REQUEST_STR, description = "Input invalid",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = ResponseMessage.class))})
    @ApiResponse(responseCode = Const.API_RESPONSE.API_STATUS_INTERNAL_SERVER_ERROR_STR, description = "Internal Server Error",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = ResponseMessage.class))})
    public ResponseEntity<?> updateProductDTO(@PathVariable Long id, @RequestBody UpdateProductDTO updateProductDTO){
        updateProductDTO.setProductLineId(id);
        productLineService.updateProductDTO(updateProductDTO);
        return successResponse("Update ProductDTO successfully");
    }
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete ProductDTO")
    @ApiResponse(responseCode = Const.API_RESPONSE.API_STATUS_OK_STR, description = "Delete productDTO completed",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = ResponseMessage.class))})
    @ApiResponse(responseCode = Const.API_RESPONSE.API_STATUS_BAD_REQUEST_STR, description = "Input invalid",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = ResponseMessage.class))})
    @ApiResponse(responseCode = Const.API_RESPONSE.API_STATUS_INTERNAL_SERVER_ERROR_STR, description = "Internal Server Error",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = ResponseMessage.class))})
    public ResponseEntity<?> deleteProductDTO(@PathVariable Long id, @RequestBody UpdateProductDTO updateProductDTO){
        updateProductDTO.setProductLineId(id);
        productLineService.deleteProductDTO(updateProductDTO);
        return successResponse("Delete ProductDTO successfully");
    }
}
