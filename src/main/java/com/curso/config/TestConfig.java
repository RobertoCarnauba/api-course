package com.curso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.curso.entities.Category;
import com.curso.entities.Order;
import com.curso.entities.Product;
import com.curso.entities.User;
import com.curso.entities.enums.OrderStatus;
import com.curso.repositories.CategoryRespositoy;
import com.curso.repositories.OrderRespositoy;
import com.curso.repositories.ProductRespositoy;
import com.curso.repositories.UserRespositoy;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRespositoy userRespositoy;
	@Autowired
	private OrderRespositoy orderRespositoy;
	@Autowired
	private CategoryRespositoy categoryRespositoy;
	@Autowired
	private ProductRespositoy productRespositoy;


	@Override
	public void run(String... args) throws Exception {

		Category cat1 = new Category(null, "Eletronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		categoryRespositoy.saveAll(Arrays.asList(cat1, cat2, cat3));
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, ""); 
		
		productRespositoy.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p3.getCategories().add(cat1);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		
		productRespositoy.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		
		User u1 = new User(1L, "Roberto Carnaúba Dias", "betom@bem","11961063734", "12das3");
		User u2 = new User(2L, "Luiz Roberto Carnaúba", "luizroberto@bem","11961063734", "12das3");
		User u3 = new User(3L, "Marcela Dias", "marceladias@bem","11961063734","12das3");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.CANCELED, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.SHIPPED, u1); 
		
		userRespositoy.saveAll(Arrays.asList(u1, u2, u3));
		orderRespositoy.saveAll(Arrays.asList(o1, o2, o3));
	}

}
