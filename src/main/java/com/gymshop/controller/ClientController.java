package com.gymshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ClientController {
	@RequestMapping("/client/home")
	public String homePage(Model model) {
		return ("/client/home");
	}
	
}
