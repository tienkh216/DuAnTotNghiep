package com.gymshop.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gymshop.service.orderService;


@Controller
public class OrderController {
	 @Autowired
	 orderService orderService;
	 
	 @RequestMapping("/client/orderList")
	 public String list(Model model, HttpServletRequest request) {
		 String username = request.getRemoteUser();
		 model.addAttribute("orders",orderService.findByUsername(username));
		 System.out.println(orderService.findByUsername(username));
	     return "client/site/ListOrder";
	 }
	 @RequestMapping("/order/detail/{id}")
		public String detail(@PathVariable("id") Long id, Model model) {
			model.addAttribute("order",orderService.findById(id));
			return "";
		}
}
