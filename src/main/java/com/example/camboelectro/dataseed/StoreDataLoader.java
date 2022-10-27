package com.example.camboelectro.dataseed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.camboelectro.model.Store;
import com.example.camboelectro.repository.StoreRepository;
import com.github.javafaker.Faker;

@Component
public class StoreDataLoader implements CommandLineRunner {

	@Autowired
	StoreRepository storeRepository;

	@Override
	public void run(String... args) throws Exception {
		loadStoreData();
	}

	private void loadStoreData() {
        Faker faker = new Faker();
		if (storeRepository.count() == 0) {
			for(var i = 0; i < 101; i++) {
                Store store = new Store();
				store.setId(i);
                store.setName(faker.company().name());

                storeRepository.save(store);
            }
		}
		System.out.println(storeRepository.count());
	}
}
