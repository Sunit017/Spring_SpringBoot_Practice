package com.example.demo.service;

import com.example.demo.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class ProductService {

    List<Product> products= new ArrayList<>( Arrays.asList(new Product(1,"Fan",2000),
            new Product(2,"Ice Cream",40),
            new Product(3,"Pen",10)));

    public List<Product> allProducts()
    {
        return products;
    }

    public Product singleProduct(int productId)
    {
        return products.stream()
                .filter(p -> p.getProductId()==productId)
                .findFirst().get();
    }

    public void addProduct(Product product)
    {
         products.add(product);
    }

}
