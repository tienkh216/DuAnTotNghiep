package com.gymshop.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/admin/home")
	public String homePage(Model model) {
		return ("/admin/index");
	}
}
