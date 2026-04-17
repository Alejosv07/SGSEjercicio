package org.example.sgsejercicio.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "products")
public class Product {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotEmpty
    @NotNull
    @Size(min = 3, max = 20)
    @Column(length = 20,unique = true,nullable = false)
    private String name;
    @Positive
    @Digits(integer = 4, fraction = 2)
    private BigDecimal price;
    @Positive
    private int stock;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}
