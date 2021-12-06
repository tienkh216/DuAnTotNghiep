package com.gymshop.controller.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gymshop.entities.Category;
import com.gymshop.entities.Product;
import com.gymshop.service.categoryService;
import com.gymshop.service.productService;

@Controller
public class UserControler {
	@Autowired
	productService productService;
	@Autowired
	categoryService categoryService;
	
	
	  @GetMapping("/login/form") 
	  public String index(Model model) {
	  model.addAttribute("message","Vui long dang nhap"); 
	  return "client/Login"; 
	  }
	  
	  @RequestMapping("/login/success") 
	  public String loginSuccess(Model model) {
	  model.addAttribute("message","Dang Nhap Thanh Cong");
	  return "redirect:/client/home";
	   }
	  
	  @RequestMapping("/login/error")
		public String loginFalure(Model model) {
			model.addAttribute("message","Dang Nhap Khong Thanh Cong");
			return("client/Login");
		}
	 
	  @RequestMapping("/login/unauthoried") 
	  public String unauthoried(Model
				  model) { model.addAttribute("message","Khong co quyen truy xuat");
				  return("client/Login"); 
	 }
	
	  @RequestMapping("/login/logoff/sucess")
		public String logoffsuccess(Model model) {
			model.addAttribute("message","Dang Xuat Thanh Cong");
			return "redirect:/client/home";
		}



}
