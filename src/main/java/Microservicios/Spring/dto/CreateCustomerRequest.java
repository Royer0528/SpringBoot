package Microservicios.Spring.dto;

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
    private int ID;
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;
    @NotNull
    private String username;

    private String password;


}
