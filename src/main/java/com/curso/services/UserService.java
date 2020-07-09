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
	
	public User insert(User obj) {
		return userRespositoy.save(obj);
	}
	
	public void delete(Long id) {
		userRespositoy.deleteById(id);
	}
	
	public User update(Long id, User obj) {
		User entity = userRespositoy.getOne(id);
		updateData(entity, obj);
		return userRespositoy.save(entity);
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
