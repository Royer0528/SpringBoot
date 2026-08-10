package Microservicios.Spring.Domain;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter

public class Product {

    private Integer id;
    private String nombre;
    private Double precio;
    private Integer stock;

}
