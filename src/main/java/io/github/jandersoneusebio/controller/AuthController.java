package io.github.jandersoneusebio.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.github.jandersoneusebio.model.User;
import io.github.jandersoneusebio.service.UserService;

@RestController
@RequestMapping("auth")
public class AuthController {
	
	@Autowired
	private UserService userService;

	@GetMapping("get-all-users")
	@ResponseBody
	public ResponseEntity<List<User>> getUserInfo(){
		List<User> users = userService.findAllUsers();
		
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	@GetMapping("authenticate")
	@ResponseBody
	public ResponseEntity<User> authenticateUser(@RequestParam("login") String login, @RequestParam("password") String password){
		Optional<User> user = userService.authenticateUser(login, password);
		
		if(user.isPresent()) {
			return new ResponseEntity<User>(user.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<User>(new User(), HttpStatus.UNAUTHORIZED);
		}
		
	}
	
}
