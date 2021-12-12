package com.gymshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gymshop.service.UserService;





@Controller
public class SecurityController {
	
//	@RequestMapping("/security/login/form") 
//	  public String loginForm(Model model) {
//	  model.addAttribute("message","Vui long dang nhap");
//	  return("client/Login"); 
//	  }
	  
	 
	/*
	 * @RequestMapping("/security/login/success") public String loginSuccess(Model
	 * model) { model.addAttribute("message","Dang Nhap Thanh Cong");
	 * return("client/site/home"); }
	 * 
	 * @RequestMapping("/security/login/error") public String loginFalure(Model
	 * model) { model.addAttribute("message","Dang Nhap Khong Thanh Cong");
	 * return("client/Login"); }
	 * 
	 * @RequestMapping("/security/unauthoried") public String unauthoried(Model
	 * model) { model.addAttribute("message","Khong co quyen truy xuat");
	 * return("client/Login"); }
	 * 
	 * @RequestMapping("/security/logoff/sucess") public String logoffsuccess(Model
	 * model) { model.addAttribute("message","Dang Xuat Thanh Cong");
	 * return("client/Login"); }
	 */
	@Autowired
	UserService userService;
	
	@RequestMapping("/oauth2/login/success")
	public String success(OAuth2AuthenticationToken oauth2) {
		userService.loginFromOAuth2(oauth2);
		return "forward:/client/home";
	}
	
}
