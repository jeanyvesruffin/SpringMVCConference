package com.ruffin.SpringMVCConference.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ruffin.SpringMVCConference.model.RegistrationModel;

@Controller
public class RegistrationController {
	
	
	// signature methode Version 1 avant passage pârametre @ModelAttribute
	// public String getRegistration(Map<String, Object> model)
	@GetMapping("registration")
	public String getRegistration(@ModelAttribute ("registrationModel") RegistrationModel registrationModel) {
		return "registration";
	}
	
	
	@PostMapping("registration")
	public String addRegistration(@ModelAttribute ("registrationModel") RegistrationModel registrationModel) {
		System.out.println("Registration "+ registrationModel.getName());
		return "registration";
	}
	

}
