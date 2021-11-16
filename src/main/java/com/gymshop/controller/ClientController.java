package com.gymshop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gymshop.entities.Product;
import com.gymshop.service.productService;

@Controller
public class ClientController {
	
	@Autowired
	productService productService;
	
	@RequestMapping(value = { "/", "/client/home" }, method = RequestMethod.GET)
	public String homePage(Model model) {
		 List<Product>list=productService.findAll(); 
		 model.addAttribute("items",list);
		return "client/site/home";
	}
	
	@RequestMapping("/client/product")
	public String clientProduct(Model model,@RequestParam("cid") Optional<String>cid) {
		if (cid.isPresent()) {
			 List<Product>list=productService.findByCategoryId(cid.get()); 
			 model.addAttribute("items",list);
		}else {
		 List<Product>list=productService.findAll(); 
		 model.addAttribute("items",list);
		}
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
