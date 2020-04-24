package com.ruffin.SpringMVCConference.controller;




import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ruffin.SpringMVCConference.model.RegistrationModel;

@Controller
public class RegistrationController {

	// Version 1
	// signature methode avant passage parametre @ModelAttribute
	// public String getRegistration(Map<String, Object> model)

	// Version 2
	// Pattern MVC
	/*
	@GetMapping("registration")
	public String getRegistration(@ModelAttribute ("registrationModel") RegistrationModel registrationModel) {
		return "registration";
	}


	@PostMapping("registration")
	public String addRegistration(@ModelAttribute ("registrationModel") RegistrationModel registrationModel) {
		System.out.println("Registration "+ registrationModel.getName());
		return "registration";
	}
	 */

	// Version 3
	// Pattern PRG ==> POST REDIRECT GET
	// Ce pattern permet la redirection Get apres un post
	// cela a pour effet lors d'un post, ajout d'un user, de vider le formulaire, a l'aide de redirection

	@GetMapping("registration")
	public String getRegistration(@ModelAttribute ("registrationModel") RegistrationModel registrationModel) {
		return "registration";
	}


	@PostMapping("registration")
	public String addRegistration(@Valid @ModelAttribute ("registrationModel") 
	RegistrationModel registrationModel,
	BindingResult result) {
		
		if(result.hasErrors()) {
			System.out.println("There were errors");
			return "registration";
		}
		
		System.out.println("Registration "+ registrationModel.getName());
		return "redirect:registration";
	}


}
