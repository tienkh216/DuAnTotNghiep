package com.gymshop.controller.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserControler {

	@GetMapping("/eeeeee")
	public String home(Model model) {
		model.addAttribute("message","Vui long dang nhap");
		return "client/site/home";
	}
	  @GetMapping("/login/form") 
	  public String index(Model model) {
	  model.addAttribute("message","Vui long dang nhap"); 
	  return "client/Login"; 
	  }
	  
	  @RequestMapping("/login/success") public String loginSuccess(Model model) {
	  model.addAttribute("message","Dang Nhap Thanh Cong");
	  return("client/site/home"); }
	  
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
				 



}
