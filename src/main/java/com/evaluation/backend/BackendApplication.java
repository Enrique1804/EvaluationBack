package com.evaluation.backend;

import com.evaluation.backend.service.ItemService;
import com.evaluation.backend.item.Item;
import com.evaluation.backend.item.Location;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ItemService itemService){
		return runner -> {
			createItem(itemService);
		};
	}

	private void createItem(ItemService itemService) {
		Item tempItem = new Item( 1818,"Chamarras","Rojas");
		Location tempLocation = new Location("CDMX","address 23",553443234);
		tempItem.setLocation(tempLocation);
		itemService.postItem(tempItem);
	}
}
