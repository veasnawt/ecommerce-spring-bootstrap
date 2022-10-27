package com.example.camboelectro.dataseed;

import java.util.ArrayList;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.camboelectro.model.Product;
import com.example.camboelectro.repository.ProductRepository;
import com.github.javafaker.Faker;

@Component
public class ProductDataLoader implements CommandLineRunner {

	@Autowired
	ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {
		loadProductData();
	}

	private void loadProductData() {
        Faker faker = new Faker();
		if (productRepository.count() == 0) {
			for(var i = 0; i < 1001; i++) {
                Product product = new Product();
				ArrayList<String> imageUrls = new ArrayList<>();
				for(var j = 0; j < new Random().nextInt((4 - 1) + 1) + 1; j++) {
					imageUrls.add("//source.unsplash.com/collection/43073761/" + (i+j));
				}
                product.setName(faker.commerce().productName());
                product.setPrice(Float.parseFloat(faker.commerce().price()));
				product.setOldPrice(Float.parseFloat(faker.commerce().price()));
                product.setRatings(new Random().nextInt(5 + 1));
				product.setNoRatings(new Random().nextInt(100 + 1));
                product.setDescription(faker.lorem().paragraph());
                product.setImageUrls(imageUrls);
				product.setColor(faker.color().name());
				product.setStoreId(new Random().nextInt(1102 - 1) + 1002);
				product.setCategoryId(new Random().nextInt(100 - 1) + 1);
				product.setRanking(new Random().nextInt(3 - 1) + 1);
                productRepository.save(product);
            }
		}
		System.out.println(productRepository.count());
	}
}
