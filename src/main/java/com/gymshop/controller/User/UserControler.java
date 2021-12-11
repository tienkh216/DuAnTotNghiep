package com.gymshop.controller.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gymshop.entities.Account;
import com.gymshop.entities.Category;
import com.gymshop.entities.Product;
import com.gymshop.service.accountService;
import com.gymshop.service.categoryService;
import com.gymshop.service.productService;



@Controller
public class UserControler {
	@Autowired
	productService productService;
	@Autowired
	categoryService categoryService;
	@Autowired
	accountService accService;
	
	
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

	  @RequestMapping("/sercurity/signup")
		public  String signUp(Model model) {	
			model.addAttribute("user",new Account());
			return "client/signup";
		}
	  @PostMapping("/sercurity/process_signup") 
		public String pro_signUp(Account acc) {	  	
			accService.save(acc);
			return "redirect:/client/home";
			
		}

}
