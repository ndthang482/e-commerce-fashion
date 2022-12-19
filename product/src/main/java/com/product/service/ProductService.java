package com.product.service;

import com.product.domain.dto.ProductDTO;
import com.product.domain.dto.ProductDetailOutput;
import com.product.domain.dto.ProductResponse;
import com.product.domain.entity.Image;
import com.product.domain.entity.Product;
import com.product.domain.entity.ProductLine;
import com.product.domain.entity.Review;
import com.product.repository.ImageRepository;
import com.product.repository.ProductLineRepository;
import com.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService{

    private final ProductRepository productRepository;

    private final IProductLineService productLineService;

    private final ImageRepository imageRepository;

    private final IReviewService reviewService;

    private final IImageService imageService;


    public ProductDTO productDTO(Product product){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setColor(product.getColor());
        productDTO.setSize(product.getSize());
        productDTO.setProductLine(productLineService.findById(product.getProductLineId()));
        productDTO.setActive(product.getActive());
        productDTO.setPrice(product.getPrice());
        productDTO.setImage(imageService.findById(product.getId()));
        productDTO.setCreatedAt(LocalDateTime.now());
        return productDTO;
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void createProduct(Product product) {
        product.setColor(product.getColor());
        product.setSize(product.getSize());
        product.setProductLineId(product.getProductLineId());
        product.setPrice(product.getPrice());
        product.setActive(product.getActive());
        product.setCreatedAt(LocalDateTime.now());
        productRepository.save(product);
    }

    @Override
    public void createProductDetail(ProductDetailOutput productDetailOutput) {
        ProductLine productLine = ProductLine.builder()
                .name(productDetailOutput.getName())
                .active(0L)
                .createdAt(LocalDateTime.now())
                .build();
        productLineService.save(productLine);

        Product product = Product.builder()
                .color(productDetailOutput.getColor())
                .size(productDetailOutput.getSize())
                .price(productDetailOutput.getPrice())
                .createdAt(LocalDateTime.now())
                .build();
        productRepository.save(product);
        List<Image> images = new ArrayList<>();
        for(int i = 0; i < productDetailOutput.getImages().size(); i ++) {
            List<Image> imageUrls = productDetailOutput.getImages();
            Image image = new Image();
            for (Image image1 : imageUrls) {
                image = Image.builder()
                        .productId(product.getId())
                        .url(image1.getUrl())
                        .description(image1.getDescription())
                        .createdAt(LocalDateTime.now())
                        .build();
            }
                images.add(image);
        }
        imageRepository.saveAll(images);

    }

    @Override
    public void updateProductDetail(Long id, ProductDetailOutput productDetailOutput) {
        productDetailOutput.setId(id);
        Product product = new Product();
        ProductLine productLine;
                productLine = ProductLine.builder()
                        .name(productDetailOutput.getName())
                        .categoryId(1L)
                        .createdAt(LocalDateTime.now())
                        .build();
        productLineService.save(productLine);
        product = Product.builder()
                .id(id)
                .color(productDetailOutput.getColor())
                .size(productDetailOutput.getSize())
                .productLineId(productLine.getId())
                .price(productDetailOutput.getPrice())
                .active(0L)
                .createdAt(LocalDateTime.now())
                .build();
        productRepository.save(product);

        Image image = new Image();
        productDetailOutput.setId(id);
        for(int i = 0; i < productDetailOutput.getImages().size(); i ++) {
            List<Image> imageUrls = productDetailOutput.getImages();
            for (Image image1 : imageUrls) {
                image = Image.builder()
                        .productId(product.getId())
                        .url(image1.getUrl())
                        .description(image1.getDescription())
                        .createdAt(LocalDateTime.now())
                        .createdAt(LocalDateTime.now())
                        .build();
            }
        }
        imageService.save(image);

    }

    @Override
    public void deleteByProductDetailId(Long id) {
        ProductDetailOutput productDetailOutput = new ProductDetailOutput();
        Product product = new Product();
        Product.builder()
                .id(productDetailOutput.getId())
                        .build();
        productRepository.deleteById(id);

        ProductLine productLine = new ProductLine();
        ProductLine.builder()
                .name(productDetailOutput.getName())
                .createdAt(LocalDateTime.now())
                .build();
        productLineService.deleteById(product.getProductLineId());

            imageService.deleteById(id + 98);

    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }


    @Override
    public void updateProduct(Long id, Product product) {
        product.setId(id);
        product.setModifiedAt(LocalDateTime.now());
        productRepository.save(product);
    }

    @Override
    public PageImpl<?> findAll(String name, String color, String size, Long priceFrom, Long priceTo, int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Product> products;
        if(Objects.nonNull(name)){
            Page<ProductLine> productLine = productLineService.findByNameLike("%" + name + "%", pageable);
            List<Long> productLineIds = productLine.stream().map(ProductLine::getId).collect(Collectors.toList());
            products = productRepository.findByProductLineIdIn(productLineIds, pageable);
        } else if(Objects.nonNull(priceFrom) && Objects.nonNull(priceTo) && Objects.nonNull(color) && Objects.nonNull(size)) {
            products = productRepository.findByColorAndSizeAndPriceBetween(color, size, priceFrom, priceTo, pageable);
        } else if (Objects.nonNull(size) && Objects.nonNull(priceFrom) && Objects.nonNull(priceTo)) {
            products = productRepository.findBySizeAndPriceBetween(size, priceFrom, priceTo, pageable);
        } else if (Objects.nonNull(color) && Objects.nonNull(priceFrom) && Objects.nonNull(priceTo)) {
            products = productRepository.findByColorAndPriceBetween(color, priceFrom, priceTo, pageable);
        } else {
           products = productRepository.findAll(pageable);
        }
        List<ProductDTO> productDTOS = products.getContent().stream()
                .map(this::productDTO)
                .collect(Collectors.toList());
        return new PageImpl<>(productDTOS, pageable, products.getTotalElements());
    }

    @Override
    public ProductDetailOutput findByProductDetail(Long id) {
        Product product = productRepository.findById(id).orElseThrow(()
                -> new NotFoundException("Not found product with id "+ id));
        ProductLine productLine = productLineService.findById(product.getProductLineId());
        return ProductDetailOutput.builder()
                .id(product.getId())
                .name(productLine.getName())
                .images(imageService.findByProductId(product.getId()))
                .color(product.getColor())
                .size(product.getSize())
                .price(product.getPrice())
                .review(reviewService.findByProductId(product.getId()))
                .createdAt(LocalDateTime.now())
                .build();
    }

}
