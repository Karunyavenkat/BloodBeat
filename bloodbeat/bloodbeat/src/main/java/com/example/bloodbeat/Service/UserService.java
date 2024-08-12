package com.example.bloodbeat.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bloodbeat.Modal.User;
import com.example.bloodbeat.Repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public User registerUser(User user) {
		 if (userRepository.existsByEmail(user.getEmail())) {
	            throw new IllegalArgumentException("Email is already in use");
	        }
	        return userRepository.save(user);
	}

	public User getUserByEmail(String email) {
		 return userRepository.findByEmail(email);
	}
	
	
}
