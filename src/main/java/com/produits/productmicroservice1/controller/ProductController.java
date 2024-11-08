package com.produits.productmicroservice1.controller;

import com.produits.productmicroservice1.configuration.ApplicationPropertiesConfiguration;
import com.produits.productmicroservice1.exceptions.ProductNotFoundException;
import com.produits.productmicroservice1.model.Product;
import com.produits.productmicroservice1.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController implements HealthIndicator {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ApplicationPropertiesConfiguration applicationPropertiesConfiguration;

    @GetMapping("/products")
    public List<Product> getAllProducts() throws ProductNotFoundException {
        List<Product> products=productRepository.findAll();

        if(products.isEmpty()){
            throw new ProductNotFoundException("aucun produit n'est disponible");
        }
        List<Product> listeLimitee =products.subList(0,applicationPropertiesConfiguration.getLimitDeProduit());

        return listeLimitee;
    }

    @Override
    public Health health() {
        return null;
    }
}
