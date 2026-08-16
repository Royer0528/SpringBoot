package Microservicios.Spring.Service;

import Microservicios.Spring.Domain.Product;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductsServiceImpl implements ProductService {

    List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(1,"Laptop",799.99,10),
            new Product(2,"Smartphone",499.99,25),
            new Product(3,"Tablet",299.99,15),
            new Product(3,"SmartWatch",199.99,30)
    ));

    @Override
    public List<Product> getProducts(){
        return products;
    }
}
