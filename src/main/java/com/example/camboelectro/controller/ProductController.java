package com.example.camboelectro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.camboelectro.exception.ProductIdMismatchException;
import com.example.camboelectro.exception.ProductNotFoundException;
import com.example.camboelectro.model.Product;
import com.example.camboelectro.repository.ProductRepository;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public Iterable findAll() {
        return productRepository.findAll();
    }

    @GetMapping("/name/{productName}")
    public List findByName(@PathVariable String productName) {
        return productRepository.findByName(productName);
    }

    @GetMapping("/{id}")
    public Product findOne(@PathVariable Long id) {
        return productRepository.findById(id)
        .orElseThrow();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@RequestBody Product product) {
        return productRepository.save(product);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void delete(@RequestBody Long id) {
        productRepository.findById(id)
        .orElseThrow();
        productRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@RequestBody Product product, @PathVariable Long id) {
        if(product.getId() != id) {
            throw new ProductIdMismatchException(null, null);
        }
        productRepository.findById(id)
        .orElseThrow();
        return productRepository.save(product);
    }
}
