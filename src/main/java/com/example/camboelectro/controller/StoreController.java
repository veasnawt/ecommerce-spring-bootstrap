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

import com.example.camboelectro.model.Store;
import com.example.camboelectro.repository.StoreRepository;

@RestController
@RequestMapping("/api/stores")
public class StoreController {

    @Autowired
    private StoreRepository storeRepository;

    @GetMapping
    public Iterable findAll() {
        return storeRepository.findAll();
    }

    @GetMapping("/name/{storeName}")
    public List findByName(@PathVariable String storeName) {
        return storeRepository.findByName(storeName);
    }

    @GetMapping("/{id}")
    public Store findOne(@PathVariable Long id) {
        return storeRepository.findById(id)
        .orElseThrow();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Store create(@RequestBody Store store) {
        return storeRepository.save(store);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void delete(@RequestBody Long id) {
        storeRepository.findById(id)
        .orElseThrow();
        storeRepository.deleteById(id);
    }
}
