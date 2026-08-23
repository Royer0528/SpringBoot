package com.Practica.Propuesta1.Spring.Controllers;

import com.Practica.Propuesta1.Spring.Config.ExternalizedConfigurations;
import com.Practica.Propuesta1.Spring.Config.dbUserConfigurations;
import com.Practica.Propuesta1.Spring.Domain.Product;
import com.Practica.Propuesta1.Spring.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductController {

    //Inyeccion de dependencia
    @Lazy
    @Autowired
    private ProductService productsService;
    @Autowired
    private ExternalizedConfigurations externalizedConfigurations;
    @Autowired
    private dbUserConfigurations dbUserConfigurations;

    @GetMapping
    public ResponseEntity<?> getProducts(){

        System.out.println(externalizedConfigurations.toString());
        System.out.println(dbUserConfigurations);

        List<Product> products = productsService.getProducts();

        return ResponseEntity.ok(products);
    }


}
