package com.ruffin.SpringMVCConference.controller;

import org.springframework.web.bind.annotation.*;


import com.ruffin.SpringMVCConference.model.User;

@RestController
public class UserController {

	@GetMapping("/user")
	public User getUser(@RequestParam(value= "firstname",defaultValue = "Jean-Yves")	String firstname,
						@RequestParam(value= "lastname",defaultValue = "Ruffin") String lastname,
						@RequestParam(value= "age",defaultValue = "39") int age) {
		User user = new User();
		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setAge(age);
		return user ;
	}

	@PostMapping("/user")
	public User postUser(User user) {
		System.out.println("User firstname :"+ user.getFirstname());
		return user ;
	}
	
}
