package com.example.camboelectro.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.camboelectro.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{
    List<Product> findByName(String productName);
}
