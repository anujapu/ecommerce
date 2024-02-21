package com.example.ecommercebackend.api.controller.product;

import com.example.ecommercebackend.model.Product;
import com.example.ecommercebackend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

   @GetMapping
    public List<Product> getProducts()
    {

        return productService.getAllProducts();
    }
}

