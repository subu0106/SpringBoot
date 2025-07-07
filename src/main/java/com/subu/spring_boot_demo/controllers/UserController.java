package com.subu.spring_boot_demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.subu.spring_boot_demo.entity.UserEntity;
import com.subu.spring_boot_demo.exceptions.ResourceNotFoundException;
import com.subu.spring_boot_demo.repository.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping
	public List<UserEntity> getUsers() {
		return userRepository.findAll();
	}
	@PostMapping
	public UserEntity createUser(@RequestBody UserEntity user) {
//		System.out.println("User Data: "+user.getName()+" "+user.getEmail());
		 
		return userRepository.save(user);
	}
	
	@GetMapping("/{id}")
	public UserEntity getUserById(@PathVariable Long id) {
		return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with this id: "+id) );		
	}
	
	@PutMapping("/{id}")
	public UserEntity UpdateUser(@PathVariable Long id, @RequestBody UserEntity user) {
		UserEntity userData= userRepository .findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found with this id: "+ id));
		userData.setName(user.getName());
		userData.setEmail(user.getEmail());
		return userRepository.save(userData);	
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Long id) {
		UserEntity userData= userRepository .findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found with this id: "+ id));
		userRepository.delete(userData);
		return ResponseEntity.ok().build();
		
	}
}
  