package com.user.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.exception.UserAlreadyPresentException;
import com.user.exception.UserNotFoundException;
import com.user.model.Role;
import com.user.model.User;
import com.user.repository.UserRepository;

@Service
public class UserService {
	
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private DoctorService doctorService;

	//register the user after checking the email address
	public User register(User user) throws UserAlreadyPresentException{
		Optional<User> u = userRepository.findByEmail(user.getEmail());
		try {
			if(u.isPresent()) {
				throw new UserAlreadyPresentException("User Already Present");
			}
		}
		catch(UserAlreadyPresentException e) {
			throw new UserAlreadyPresentException(e.getMessage());
		}
		return userRepository.save(user);
		
	}
	
	
	
	//login the user
	public User login(String email, String pass) throws UserNotFoundException {
		System.out.println(email);
		User u = userRepository.findByEmail(email)
				.orElseThrow(()->{
				return new UserNotFoundException("user not available");
				});
		
		if(email.matches(u.getEmail()) && pass.matches(u.getPassword())) {
//			adminService.performActions();
			System.out.println(u.getEmail()+"-------------"+u.getPassword());
			return u;
		}
//		else if(user.getRole().equals("Doctor")) {
//			doctorService.performActions();
//		}

		throw new UserNotFoundException("User Not Available");
	}
	
}
