package com.example.shop.mapping;

import com.example.shop.dao.entity.*;
import com.example.shop.dto.BrandDTO;
import com.example.shop.dto.ProductDTO;
import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.dozer.loader.api.FieldsMappingOptions.customConverter;

@Configuration
public class MappingConfiguration {

    @Bean
    public DozerBeanMapper mapper() {
        DozerBeanMapper mapper = new DozerBeanMapper();
        mapper.addMapping(objectMappingBuilder);
        return mapper;
    }

    private BeanMappingBuilder objectMappingBuilder = new BeanMappingBuilder() {
        @Override
        protected void configure() {

            mapping(ProductDTO.class, HDD.class)
                    .fields("hddCapacity", "capacity");

            mapping(ProductDTO.class, Laptop.class)
                    .fields("laptopSize", "size"
                    , customConverter("com.example.shop.mapping.SizeAttributeConverter"));

            mapping(ProductDTO.class, Monitor.class)
                    .fields("monitorDiagonal", "diagonal");

            mapping(ProductDTO.class, PC.class)
                    .fields("pcFormFactor", "formFactor");

            mapping(BrandDTO.class, Brand.class);

        }
    };
}
