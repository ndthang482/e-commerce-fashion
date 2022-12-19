package com.product.controller;

import com.product.service.IProductLineService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productLine")
@RequiredArgsConstructor
public class ProductLineController extends BaseController{

    private final IProductLineService productLineService;

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProductLine(@PathVariable("id") Long id){
        productLineService.deleteById(id);
        return successResponse("Deleted productLine successfully!");
    }
}
