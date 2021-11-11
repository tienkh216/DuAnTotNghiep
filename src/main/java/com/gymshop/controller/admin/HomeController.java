package com.gymshop.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/admin/home")
	public String admin() {
		return "redirect:/admin/index.html";
	}
	
	
}
