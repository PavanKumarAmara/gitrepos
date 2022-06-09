package com.criticalriver.training.projects.springboot.loginmodule.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	@RequestMapping("/homepage")
	public String navigateToHome(){
		System.out.println("home");
		return "home";
	}
}
