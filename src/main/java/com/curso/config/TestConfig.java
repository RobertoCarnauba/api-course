package com.curso.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.curso.entities.User;
import com.curso.repositories.UserRespositoy;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRespositoy userRespositoy;

	@Override
	public void run(String... args) throws Exception {

		User u1 = new User(1L, "Betim", "betim@bem", "12das3");
		User u2 = new User(2L, "Betim", "betim@bem", "12das3");

		userRespositoy.saveAll(Arrays.asList(u1, u2));
		
	}

}
