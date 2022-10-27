package com.example.camboelectro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.camboelectro.model.Category;
import com.example.camboelectro.repository.CategoryRepository;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public Iterable findAll() {
        return categoryRepository.findAll();
    }

    @GetMapping("/name/{categoryName}")
    public List findByName(@PathVariable String categoryName) {
        return categoryRepository.findByName(categoryName);
    }

    @GetMapping("/{id}")
    public Category findOne(@PathVariable Long id) {
        return categoryRepository.findById(id)
        .orElseThrow();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Category create(@RequestBody Category category) {
        return categoryRepository.save(category);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void delete(@RequestBody Long id) {
        categoryRepository.findById(id)
        .orElseThrow();
        categoryRepository.deleteById(id);
    }
}