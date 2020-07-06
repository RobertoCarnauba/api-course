package com.curso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.curso.entities.Order;
import com.curso.entities.User;
import com.curso.entities.enums.OrderStatus;
import com.curso.repositories.OrderRespositoy;
import com.curso.repositories.UserRespositoy;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRespositoy userRespositoy;
	@Autowired
	private OrderRespositoy orderRespositoy;


	@Override
	public void run(String... args) throws Exception {

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
