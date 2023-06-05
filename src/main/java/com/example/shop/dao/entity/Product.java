package com.example.shop.dao.entity;

import com.example.shop.dao.ProductType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "products")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, name = "TYPE")
public abstract class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @NonNull
    protected Long id;

    @Column(name = "serial_number", nullable = false)
    @NonNull
    protected String serialNumber;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "brand_id", nullable = false)
    @NonNull
    protected Brand brand;

    @Column(name = "price", nullable = false)
    @NonNull
    protected BigDecimal price;

    @Column(name = "stock", nullable = false)
    @NonNull
    protected Long stock;

    @Column(name = "type", insertable = false, updatable = false)
    @Enumerated(EnumType.STRING)
    private ProductType type;

}
