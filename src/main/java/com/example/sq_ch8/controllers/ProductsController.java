package com.example.sq_ch8.controllers;

import com.example.sq_ch8.model.Product;
import com.example.sq_ch8.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductsController {

    private final ProductService productService;

    public ProductsController(
            ProductService productService
    ) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String viewProducts(Model model) {
        var products = productService.findAll();
        model.addAttribute("products", products);
        return "products.html";
    }

    @PostMapping(path = "/products")
    public String addProduct(
            Product p,
            Model model
    ) {
        productService.addProduct(p);

        var products = productService.findAll();
        model.addAttribute("products", products);

        return "products.html";
    }
}
