package com.ecomm.product.controller;

import com.ecomm.product.entity.Product;
import com.ecomm.product.exceptions.ProductNotFoundException;
import com.ecomm.product.repository.ProductRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @RequestMapping(method = RequestMethod.GET , value = "/products")
    public Iterable<Product> getProducts(){
        return repository.findAll();
    }

    @PostMapping("/products")
    Product postProduct(@RequestBody Product newProduct){
        return repository.save(newProduct);
    }

    @GetMapping("/products/{id}")
    Product id(@PathVariable String id){
        return repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }


}
