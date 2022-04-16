package tn.esprit.springboot.exceptions;

public class UserNotFoundException extends Exception {
	public UserNotFoundException(String message){
		super(message);
	}
}