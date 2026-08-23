package com.Practica.Propuesta1.Spring.Domain;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter

public class Customer {

    private int ID;
    private String nombre;
    private String username;
    private String password;

}