package com.santi.inventoryservice;

import com.santi.inventoryservice.model.Inventory;
import com.santi.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}
	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository){
		return args -> {
			Inventory inventory1 = new Inventory();
			inventory1.setSkuCode("yonose");
			inventory1.setQuantity(0);

			Inventory inventory2 = new Inventory();
			inventory2.setSkuCode("yosise");
			inventory2.setQuantity(400);

			inventoryRepository.save(inventory1);
			inventoryRepository.save(inventory2);
		};
	}

}
