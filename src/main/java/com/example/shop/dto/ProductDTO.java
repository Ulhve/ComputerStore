package com.example.shop.dto;

import com.example.shop.dao.entity.PC;
import com.example.shop.dao.ProductType;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDTO {

    private Long id;

    @NotNull(message = "Необходимо указать серийный номер")
    private String serialNumber;

    @NotNull(message = "Необходимо указать производителя")
    private BrandDTO brand;

    @NotNull(message = "Необходимо указать цену")
    private BigDecimal price;

    @NotNull(message = "Необходимо указать остаток на складе")
    private Long stock;

    private PC.FormFactor pcFormFactor;
    private Integer laptopSize;
    private Double monitorDiagonal;
    private Double hddCapacity;

    @NotNull(message = "Необходимо указать тип продукта: PC, LAPTOP, HDD, MONITOR")
    private ProductType type;

    @AssertTrue(message = "Для ПК необходимо указать форм-фактор: DESKTOP, NETTOP, MONOBLOCK")
    private boolean doesPcHaveFormFactor() {
        return (getType() != ProductType.PC) || (getPcFormFactor() != null);
    }

    @AssertTrue(message = "Для ноутбука необходимо указать размер")
    private boolean doesLaptopHaveSize() {
        return (getType() != ProductType.LAPTOP) || (getLaptopSize() != null);
    }

    @AssertTrue(message = "Для монитора необходимо указать диагональ")
    private boolean doesMonitorHaveDiagonal() {
        return ((getType() != ProductType.MONITOR) || (getMonitorDiagonal() != null));
    }

    @AssertTrue(message = "Для жесткого диска необходимо указать его объем")
    private boolean doesHddHaveCapacity() {
        return (getType() != ProductType.HDD) || (getHddCapacity() != null);
    }

}
