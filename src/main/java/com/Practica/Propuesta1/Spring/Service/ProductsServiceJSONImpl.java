package com.Practica.Propuesta1.Spring.Service;

import com.Practica.Propuesta1.Spring.Domain.Product;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.util.List;

//Bean de servicio, obtine los recursos desde la lista JSON
@Service
@ConditionalOnProperty(name = "service.products", havingValue = "json")
public class ProductsServiceJSONImpl implements ProductService{

    @Override
    public List<Product> getProducts() {
        List<Product> products;


        products = new ObjectMapper()
                .readValue(this.getClass().getResourceAsStream("/products.json"),
                        new TypeReference<List<Product>>() {});

        return products;
    }
}
