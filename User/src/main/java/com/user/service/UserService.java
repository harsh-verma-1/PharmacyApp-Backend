package com.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public User register(User user) {
		return userRepository.save(user);
	}
	
	public User login(Role role) throws UserNotFoundException {
		if(role==Role.Admin) {
			User user = adminService.performActions();
		}
		else if(role==Role.Doctor){
			User user = doctorService.performActions();
		}
		throw new UserNotFoundException("User Not Available");
	}
	
}
