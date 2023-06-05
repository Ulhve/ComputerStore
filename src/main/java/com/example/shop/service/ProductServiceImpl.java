package com.example.shop.service;

import com.example.shop.dao.ProductType;
import com.example.shop.dao.entity.*;
import com.example.shop.dao.repository.ProductRepository;
import com.example.shop.dto.ProductDTO;
import com.example.shop.exception.ProductNotFoundException;
import lombok.RequiredArgsConstructor;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final DozerBeanMapper mapper;

    @Override
    public List<ProductDTO> findAllProductsByType(ProductType productType) {
        return productRepository.findProductsByType(productType).stream()
                .map(product -> mapper.map(product, ProductDTO.class))
                .toList();
    }

    @Override
    public ProductDTO findProductById(Long id) {
        return productRepository.findById(id)
                .map(product -> mapper.map(product, ProductDTO.class))
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    @Override
    public ProductDTO updateProduct(ProductDTO productDTO) {
        ProductDTO oldProduct = findProductById(productDTO.getId());
        Product product = (Product) mapper.map(productDTO, oldProduct.getType().getClassEntity());
        Product newProduct = productRepository.saveAndFlush(product);
        return mapper.map(newProduct, ProductDTO.class);
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = (Product) mapper.map(productDTO, productDTO.getType().getClassEntity());
        product = productRepository.save(product);
        return mapper.map(product, ProductDTO.class);
    }
}
