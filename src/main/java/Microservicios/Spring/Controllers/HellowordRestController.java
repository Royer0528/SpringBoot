package Microservicios.Spring.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HellowordRestController {

    @GetMapping({"/hello/xd", "/hw", "/hola"})
    public String helloword(){
        System.out.println("Solicitud ejecutada");
        return "helloword";
    }
}
