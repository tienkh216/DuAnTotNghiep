package com.gymshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ClientController {
	@RequestMapping("/client/home")
	public String homePage(Model model) {
		return "client/site/home";
	}
	
	@RequestMapping("/client/product")
	public String clientProduct(Model model) {
		return ("client/site/products");
	}
	
	@RequestMapping("/client/cart")
	public String shoppingCart(Model model) {
		return ("client/site/shoppingCart");
	}
	
	@RequestMapping("/client/checkout")
	public String clientCheckout(Model model) {
		return ("client/site/checkout");
	}
	
	@RequestMapping("/client/productDetail")
	public String productDetail(Model model) {
		return ("client/site/productDetail");
	}
	
}
