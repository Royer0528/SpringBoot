package Microservicios.Spring.Controllers;

import Microservicios.Spring.Domain.Customer;
import Microservicios.Spring.dto.CreateCustomerRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 *
 * Aqui se utiliza el metodo RequestMapping a nivel de clase
 */
@RestController
@RequestMapping("/clientes")
public class CustomerController {

    private List<Customer> customers = new ArrayList<>(Arrays.asList(
            new Customer(123,"Rogelio Garcia","TitoDobleP","contraseña123"),
            new Customer(234,"Jack Teller","TJ","sons_anarchy"),
            new Customer(456,"bruce lee","KUNFU","Grulla"),
            new Customer(567,"Carl Johnson","CJ","Smoke")
    ));

    /**
     *
     * Controlador del tipo GET para obtner una lista de clientes
     * @return: Retorna lista de clientes
     */
    /**
     * Aqui se utiliza el metodo RequestMapping a nivel de metodo(Ambas sintaxys son iguales)
     */
    //@RequestMapping(method = RequestMethod.GET)
    @GetMapping
            public ResponseEntity<List<Customer>> getCustomers(){

        return ResponseEntity.ok(customers);
            }

    /**
     *Cotrolador rest del tipo GET para obtener un unico regitro
     * @param username Se utiliza el parametro username para obtner un registro en especifico
     * @return retorna un customerId
     */
    //@RequestMapping(value = "/{username}" , method = RequestMethod.GET)
    @GetMapping("/{username}")
    public ResponseEntity <?> getcliente(@PathVariable String username){
        for (Customer c : customers) {
            if(c.getUsername().equalsIgnoreCase(username)){
                return ResponseEntity.ok(c);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado con username: " + username);
    }

    /**
     * Controlador rest del tipo POST para crear un nuevo registro en la lista de clientes
     * @param request parametro utilizado para crear el nuevo registro
     * @return debe retornar un 200 created
     */
    // @RequestMapping(method = RequestMethod.POST)
    @PostMapping
    public ResponseEntity<?> postCliente(@Valid @RequestBody CreateCustomerRequest request){
        Customer customer = new Customer();

        customer.setID(request.getID());
        customer.setNombre(request.getNombre());
        customer.setUsername(request.getUsername());
        customer.setPassword(request.getPassword());

        customers.add(customer);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{username}")
                .buildAndExpand(customer.getUsername())
                .toUri();

        //return ResponseEntity.created(location).build();
        return ResponseEntity.created(location).body(request);
    }

    // @RequestMapping(method = RequestMethod.PUT)
    @PutMapping
    public ResponseEntity<?> putCliente(@RequestBody Customer customer){
        for(Customer c : customers){
            if(c.getID() == customer.getID()){
                c.setNombre(customer.getNombre());
                c.setUsername(customer.getUsername());
                c.setPassword(customer.getPassword());

                return ResponseEntity
                        .noContent()
                        .build();
            }
        }
        return ResponseEntity
                .notFound()
                .build();
    }

    /**
     *
     * Controlador rest para el tipo de peticiones http delete
     * @param id se utilizar le parametro id para indicar un id especifico de un cliente para eliminarlo
     * @return retorna un tipo de respuesta 200 despues de eliminar el cliente con el id especificado
     */
    // @RequestMapping(value = ("/{id}"), method = RequestMethod.DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity <?> deleteClientente(@PathVariable int id){
        for(Customer c : customers){
            if(c.getID() == id){
                customers.remove(c);
                return ResponseEntity
                        .noContent()
                        .build();
            }  
        }
        return ResponseEntity
                .notFound()
                .build();
    }

    /**
     * Metodo http del tipo patch
     * @param customer se utiliza el parametro customer del tipo Customer para hacer la modificacion parcial de los
     *                 elementos del objeto
     * @return Retorna un json con el campo modificado
     */
    // @RequestMapping(method = RequestMethod.PATCH)
    @PatchMapping
    public ResponseEntity <?> patchClientes(@RequestBody Customer customer){
        for(Customer c : customers){
            if(c.getID() == customer.getID()){
                if(customer.getNombre() != null){
                    c.setNombre(customer.getNombre());
                }
                if(customer.getUsername() != null){
                    c.setUsername(customer.getUsername());
                }
                if(customer.getPassword() != null){
                    c.setPassword(customer.getPassword());
                }

                return ResponseEntity
                        .ok("Cliente actualizado correctamente: " + customer.getNombre());
            }
        }
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Cliente no encontrado con el id: " + customer.getID());
    }
}































