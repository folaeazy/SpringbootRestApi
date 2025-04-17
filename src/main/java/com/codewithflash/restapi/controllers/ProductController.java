package com.codewithflash.restapi.controllers;
import com.codewithflash.restapi.model.Product;
import org.springframework.ui.Model;
import com.codewithflash.restapi.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {
    private  final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String viewProducts( Model model) {
        var products = productService.getProducts();
        model.addAttribute("products", products);
        return "products.html";

    }
    @PostMapping("/products")
    public String addProduct(
            @RequestParam String name,
            @RequestParam double price,
            Model model
    ) {
        Product p = new Product();
        p.setName(name);
        p.setPrice(price);

        productService.addProduct(p);
        var products = productService.getProducts();
        model.addAttribute("products" , products);
        return "products.html";
    }

}
