package com.example.camboelectro.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.camboelectro.model.Store;

public interface StoreRepository extends CrudRepository<Store, Long> {
    List<Store> findByName(String storeName);
}
