package io.github.jandersoneusebio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import io.github.jandersoneusebio.model.User;
import io.github.jandersoneusebio.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public List<User> findAllUsers(){
		return userRepository.findAll();
	}
	
	public User signUpUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}
	
	public Optional<User> authenticateUser(String login, String password) {
		Optional<User> user = userRepository.findByLogin(login);
		
		if(user.isPresent()) {
			if(passwordEncoder.matches(password, user.get().getPassword())) {
				return user;
			}
		} 
		
		return Optional.empty();
	}
	
}
