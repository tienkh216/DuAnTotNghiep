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
	
	@RequestMapping("/admin/product")
	public String adminProduct(Model model) {
		return ("/admin/products");
	}
	
	@RequestMapping("/admin/order")
	public String adminOrder(Model model) {
		return ("/admin/orders");
	}
	
	@RequestMapping("/admin/category")
	public String adminCategory(Model model) {
		return ("/admin/categories");
	}
}
