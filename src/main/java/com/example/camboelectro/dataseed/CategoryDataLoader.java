package com.example.camboelectro.dataseed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.camboelectro.model.Category;
import com.example.camboelectro.repository.CategoryRepository;
import com.github.javafaker.Faker;

@Component
public class CategoryDataLoader implements CommandLineRunner {

	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public void run(String... args) throws Exception {
		loadCategoryData();
	}

	private void loadCategoryData() {
        Faker faker = new Faker();
		if (categoryRepository.count() == 0) {
			for(var i = 0; i < 101; i++) {
                Category category = new Category();
                category.setName(faker.commerce().department());

                categoryRepository.save(category);
            }
		}
		System.out.println(categoryRepository.count());
	}
}
