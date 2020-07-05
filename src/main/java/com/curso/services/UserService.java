package com.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.entities.User;
import com.curso.repositories.UserRespositoy;

@Service
public class UserService {
	
	@Autowired
	private UserRespositoy userRespositoy;
	
	public List<User> findAll(){
		return userRespositoy.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = userRespositoy.findById(id);
		return obj.get();
	}

}
