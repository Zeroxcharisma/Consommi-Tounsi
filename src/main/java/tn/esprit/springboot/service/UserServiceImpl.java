package tn.esprit.springboot.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.RequestBody;

import tn.esprit.springboot.entity.Role;

import tn.esprit.springboot.entity.User;
import tn.esprit.springboot.fileUpmessage.ResponseMessage;
import tn.esprit.springboot.repository.UserRepository;
import tn.esprit.springboot.service.IUserService;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements IUserService {
	

	
	@Autowired
	UserRepository ur;
	
	/*@Autowired
	IUserService us;*/
	
	@Override
	public User retrieveUserById(int idUser) {
		return ur.findById(idUser).get();
	}

	@Override
	public List<User> retrieveAllUsers() {
		return (List<User>) ur.findAll();
	}

	
	
	
	@Override
	public ResponseEntity<?> addUser(User user) {
		user.setStateUser(true);
		user.setRole(Role.CLIENT);
		ur.save(user);
		return ResponseEntity.ok(new ResponseMessage("user added Succefully"));
	}
	
	
	@Override
	public User updateUser(@RequestBody User user) throws Exception {

			user.setPassword(user.getPassword());
			user.setPassword(user.getConfirmPasswordUser());
		
		return ur.save(user);
	}
	
	@Override
	public boolean deleteUser(int idUser) {
		if (ur.existsById(idUser)){
			ur.deleteById(idUser);
			return true;
		}else
		return false;
	}
}
