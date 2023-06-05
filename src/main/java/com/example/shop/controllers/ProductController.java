package com.example.shop.controllers;

import com.example.shop.dao.ProductType;
import com.example.shop.dto.ProductDTO;
import com.example.shop.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ProductDTO createProduct(
            @Valid @RequestBody ProductDTO productDTO
    ) {
        return productService.createProduct(productDTO);
    }

    @PutMapping
    public ProductDTO updateProduct(
            @RequestBody ProductDTO productDTO
    ) {
        return productService.updateProduct(productDTO);
    }

    @GetMapping("/{productId}")
    public ProductDTO getProductById(
            @PathVariable(value = "productId", required = true) Long productId
    ) {
        return productService.findProductById(productId);
    }

    @GetMapping("/type/{productType}")
    public List<ProductDTO> getProductsByType(
            @PathVariable(value = "productType", required = true) ProductType productType
    ) {
        return productService.findAllProductsByType(productType);
    }

}
