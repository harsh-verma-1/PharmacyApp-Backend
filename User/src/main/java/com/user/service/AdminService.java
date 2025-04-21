package com.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.model.User;
import com.user.repository.UserRepository;

@Service
public class AdminService {

	@Autowired
	private UserRepository userRepository;
	
	public User performActions() {
		return null;
	}

}
