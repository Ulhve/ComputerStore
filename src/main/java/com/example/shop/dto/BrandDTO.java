package com.example.shop.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BrandDTO {

    private Long id;

    @NotNull(message = "Необходимо указать название брэнда")
    private String name;

}
