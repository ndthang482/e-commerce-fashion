package com.product.controller;

import com.product.service.IImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/image")
@RestController
public class ImageController extends BaseController{
    private final IImageService iImageService;

    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id){
        return successResponse(iImageService.findById(id));
    }
}
