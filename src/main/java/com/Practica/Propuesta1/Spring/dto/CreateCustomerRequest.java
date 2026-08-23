package com.Practica.Propuesta1.Spring.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter

@JsonIgnoreProperties(ignoreUnknown = false)
public class CreateCustomerRequest {

    @NotNull
    private int ID;
    @NotNull
    private String nombre;
    @NotNull
    private String username;
    @NotNull
    private String password;
}
