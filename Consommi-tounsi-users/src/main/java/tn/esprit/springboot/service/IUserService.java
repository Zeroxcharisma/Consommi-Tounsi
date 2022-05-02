package tn.esprit.springboot.service;

import java.util.List;

import org.springframework.http.ResponseEntity;


import tn.esprit.springboot.entity.User;


public interface IUserService {
	
	 ResponseEntity<?> addUser(User user);
	
	User updateUser(User user) throws Exception;
	
	boolean deleteUser(int idUser);

	User retrieveUserById(int idUser);
	
	List<User> retrieveAllUsers();
	
	

}
