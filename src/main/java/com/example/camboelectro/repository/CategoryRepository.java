package com.example.camboelectro.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.camboelectro.model.Category;
import com.example.camboelectro.model.Store;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    List<Store> findByName(String categoryName);
}
