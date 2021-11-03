package com.gymshop.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class HomeController {
	@RequestMapping("/home")
	public String homePage(Model model) {
		return ("/admin/index");
	}
	@RequestMapping("/products")
	public String products(Model model) {
		return ("/admin/products");
	}
}
