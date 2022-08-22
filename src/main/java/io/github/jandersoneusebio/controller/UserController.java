package io.github.jandersoneusebio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.github.jandersoneusebio.model.User;
import io.github.jandersoneusebio.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("sign-up")
	@ResponseBody
	public ResponseEntity<User> signUp(@RequestBody User user){
		User newUser = userService.signUpUser(user);
		
		return new ResponseEntity<User>(newUser, HttpStatus.CREATED);
	}
	
}
