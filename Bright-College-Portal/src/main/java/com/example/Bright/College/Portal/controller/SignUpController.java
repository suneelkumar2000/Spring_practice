package com.example.Bright.College.Portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.Bright.College.Portal.model.SignUpForm;

@Controller
public class SignUpController {

	//method to get signup form
		@GetMapping(path = "/index")
		public String getSignUpForm() {
			return "signup";
		}
		
	//method to get signupform details
	@GetMapping(path = "signup-submit")
	public String submitSignUp(@ModelAttribute SignUpForm signUpForm,Model model) {
		model.addAttribute("signUpForm",signUpForm);
		return "signup-success";
	}
}
