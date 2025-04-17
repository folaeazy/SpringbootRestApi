package com.codewithflash.restapi.services;

import com.codewithflash.restapi.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private List<Product> products  = new ArrayList<>();

    public  void addProduct(Product newProduct) {
        products.add(newProduct);
    }

    public List<Product> getProducts() {
        return products;
    }
}
