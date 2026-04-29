package Microservicios.Spring.Domain;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
//Clase POJO
public class Customer {
    //atributos
    private int ID;
    private String nombre;
    private String username;
    private String password;

}