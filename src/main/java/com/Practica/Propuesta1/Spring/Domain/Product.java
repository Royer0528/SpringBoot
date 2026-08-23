package com.Practica.Propuesta1.Spring.Domain;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter

public class Product {

    private Integer id;
    private String name;
    private Double price;
    private Integer stock;

}
