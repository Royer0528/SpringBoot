package Microservicios.Spring.Service;

import Microservicios.Spring.Domain.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

//Bean de servicio, obtine los recursos desde la lista JSON
@Service("jsonResourceService")
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
