package com.codewithflash.restapi;

import com.codewithflash.restapi.controllers.ProductController;
import com.codewithflash.restapi.controllers.PurchaseController;
import com.codewithflash.restapi.model.Product;
import com.codewithflash.restapi.repository.PurchaseRepository;
import com.codewithflash.restapi.services.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ProductControllerUnitTest {
    @Mock
    private ProductService productService;

    @Mock
    private Model model;

    @InjectMocks
    private ProductController productController;

    @Test
    @DisplayName("add new product success test")
    public void addProductSuccessTest() {
        Product products = new Product();
        products.setName("maker");
        products.setPrice(20.00);

        given(productService.getProducts()).willReturn(List.of(products));
        //Testing
        String result = productController.addProduct(products, model);

        assertEquals("products.html", result);
        verify(model).addAttribute("products", productService.getProducts());





    }
}
