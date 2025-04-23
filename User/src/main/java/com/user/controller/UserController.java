package com.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.user.exception.UserAlreadyPresentException;
import com.user.exception.UserNotFoundException;
import com.user.model.Role;
import com.user.model.User;
import com.user.service.UserService;

@RestController
@CrossOrigin


@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<User> register(@RequestBody User user) throws UserAlreadyPresentException{
		return new ResponseEntity<User>(userService.register(user),HttpStatus.OK);
	}
	
	@GetMapping("/login")
	public ResponseEntity<User> login(@RequestParam String email, @RequestParam String pass) throws UserNotFoundException{
		return new ResponseEntity<User>(userService.login(email,pass),HttpStatus.OK);
	}
	
	
	
}
