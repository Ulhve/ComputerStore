package com.example.shop.service;

import com.example.shop.dao.ProductType;
import com.example.shop.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    List<ProductDTO> findAllProductsByType(ProductType productType);

    ProductDTO findProductById(Long id);

    ProductDTO updateProduct(ProductDTO productDTO);

    ProductDTO createProduct(ProductDTO productDTO);

}
