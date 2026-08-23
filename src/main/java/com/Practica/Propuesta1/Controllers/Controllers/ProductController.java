package com.Practica.Propuesta1.Controllers.Controllers;

import Microservicios.Spring.Config.ExternalizedConfigurations;
import Microservicios.Spring.Domain.Product;
import Microservicios.Spring.Service.ProductService;
import Microservicios.Spring.Service.ProductsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    @GetMapping
    public ResponseEntity<?> getProducts(){

        System.out.println(externalizedConfigurations.toString());

        List<Product> products = productsService.getProducts();

        return ResponseEntity.ok(products);
    }


}
