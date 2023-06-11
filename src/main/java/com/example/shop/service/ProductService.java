package com.example.shop.service;

import com.example.shop.dao.ProductType;
import com.example.shop.dto.ProductDTO;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public interface ProductService {

    List<ProductDTO> findAllProductsByType(ProductType productType);

    ProductDTO findProductById(Long id);

    ProductDTO updateProduct(@Valid ProductDTO productDTO);

    ProductDTO createProduct(@Valid ProductDTO productDTO);

}
