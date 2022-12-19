package com.product.controller;

import com.product.common.AppConstants;
import com.product.domain.dto.ProductDetailOutput;
import com.product.domain.entity.Product;
import com.product.domain.entity.ProductLine;
import com.product.service.IProductLineService;
import com.product.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController extends BaseController{

    private final IProductService productService;
//
//    @GetMapping("")
//    private List<Product> findAll(){
//        return productService.findAll();
//    }
    @GetMapping("")
    private ResponseEntity<?> findAllByNameLikeAndPriceBetween(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Long priceFrom,
            @RequestParam(required = false) Long priceTo,
            @RequestParam(required = false) String color,
            @RequestParam(required = false) String size,
            @RequestParam(required = false, defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int pageNo,
            @RequestParam(required = false, defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int pageSize,
            @RequestParam(required = false, defaultValue = AppConstants.DEFAULT_SORT_BY) String sortBy,
            @RequestParam(required = false, defaultValue = AppConstants.DEFAULT_SORT_DIRECTION) String sortDir
    )
    {
        return successResponse(productService.findAll(name, color, size, priceFrom, priceTo, pageNo, pageSize, sortBy, sortDir));
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findProductDetailByProductId(@PathVariable("id") Long id){
        return successResponse(productService.findByProductDetail(id));
    }
    @PostMapping("")
//    @PreAuthorize("hasAuthority('admin)")
    public ResponseEntity<?> addProduct(@RequestBody Product product){
        productService.createProduct(product);
        return successResponse("Created product successfully!");
    }
    @PostMapping("/{id}")
//    @PreAuthorize("hasAuthority('admin)")
    public ResponseEntity<?> updateProduct(@PathVariable("id") Long id, @RequestBody Product product){
        productService.updateProduct(id, product);
        return successResponse("Updated product successfully!");
    }

    @DeleteMapping("/delete/{id}")
//    @PreAuthorize("hasAuthority('admin)")
    public ResponseEntity<?> deleteProductById(@PathVariable("id") Long id){
        productService.deleteById(id);
        return successResponse("Deleted product successfully!");
    }
    @PostMapping("/detail")
    public ResponseEntity<?> createProductDetail(@RequestBody ProductDetailOutput productDetailOutput){
        productService.createProductDetail(productDetailOutput);
        return successResponse("Created productDetail successfully!");
    }
    @PostMapping("/detail/{id}")
    public ResponseEntity<?> updateProductDetailById(@PathVariable("id") Long id, @RequestBody ProductDetailOutput productDetailOutput){
        productService.updateProductDetail(id, productDetailOutput);
        return successResponse("Updated productDetail by id successfully!");
    }

    @DeleteMapping("/detail/delete/{id}")
    public ResponseEntity<?> deleteProductDetailById(@PathVariable("id") Long id){
        productService.deleteByProductDetailId(id);
       return successResponse("Deleted productDetail by id successfully!");
    }
}
