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
	 
	 @RequestMapping("/client/order/list")
	 public String list(Model model, HttpServletRequest request) {
		 String username = request.getRemoteUser();
		 model.addAttribute("orders",orderService.getOrderListByUsername(username));
	     return "client/site/ListOrder";
	 }
	 
	 @RequestMapping("/client/order/cancelOrderList")
	 public String cancelList(Model model, HttpServletRequest request ) {
	 String username = request.getRemoteUser();
	 model.addAttribute("orders",orderService.getCancelOrderListByUsername(username));
     return "client/site/ListCancelOrder";
	 }
	 
	 
	 @RequestMapping("/client/order/orderDetail/{id}")
		public String detail(@PathVariable("id") Long id, Model model) {
			model.addAttribute("order",orderService.findById(id));
			return "client/site/OrderDetail";
	}
	@RequestMapping("/client/order/cancel/{id}")
	public String cancelOrder(@PathVariable("id") Long id) {
		orderService.cancelOrder(id);
		return "redirect:/client/order/list";

	}
}
