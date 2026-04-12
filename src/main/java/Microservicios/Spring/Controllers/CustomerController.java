package Microservicios.Spring.Controllers;

import Microservicios.Spring.Domain.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@RestController
public class CustomerController {

    private List<Customer> customers = new ArrayList<>(Arrays.asList(
            new Customer(123,"Rogelio Garcia","TitoDobleP","contraseña123"),
            new Customer(234,"Jack Teller","TJ","sons_anarchy"),
            new Customer(456,"bruce lee","KUNFU","Grulla"),
            new Customer(567,"Carl Johnson","CJ","Smoke")
    ));

    @GetMapping("clientes")
    public List<Customer> getCustomers(){
        return customers;
    }

    @GetMapping("/clientes/{username}")
    public Customer getcliente(@PathVariable String username){
        for (Customer c : customers) {
            if(c.getUsername().equalsIgnoreCase(username)){
                return c;
            }
        }
        return null;
    }

    @PostMapping("/clientes")
    public Customer postCliente(@RequestBody Customer customer){
        customers.add(customer);
        return customer;
    }

}

































