package tn.esprit.springboot.controller;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.springboot.service.IUserService;


import tn.esprit.springboot.entity.User;


@RestController
@RequestMapping("/api/v1")
public class UserController  {
	
	@Autowired
	IUserService us;
	
    // Url : http://localhost:8083/springmvc/api/v1/retrieve-all-user 
	@GetMapping("/retrieve-all-user")
	@ResponseBody
	public List<User> getUser() {
	List<User> users = us.retrieveAllUsers();
	return users;
	}
	
	
	// Url : http://localhost:8083/springmvc/api/v1/add-user 
	@PostMapping("/add-user")
	@ResponseBody
	public ResponseEntity<?> addUser(@RequestBody User user) {
		return us.addUser(user);
	
	}
	// Url : http://localhost:8083/springmvc/api/v1/delete-user/1
	@DeleteMapping("/delete-user/{idUser}")
	@ResponseBody
	public void deleteUser(@PathVariable("idUser") int userId) {
	us.deleteUser(userId);
	}
	
	// Url : http://localhost:8083/springmvc/api/v1/update-user
	@PutMapping("/update-user")
	@ResponseBody
	public User updateUser(@RequestBody User user) throws Exception {
	return us.updateUser(user);
	}
	
	// Url : http://localhost:8083/springmvc/api/v1/retrieve-user-by-id/2
	@GetMapping("/retrieve-user-by-id/{user-id}")
	@ResponseBody
	public User retrieveUserById(@PathVariable("user-id") int userId) {
	return us.retrieveUserById(userId);
	}
	
	
	
	
	
}
