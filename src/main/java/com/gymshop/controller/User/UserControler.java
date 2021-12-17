package com.gymshop.controller.User;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gymshop.entities.Account;
import com.gymshop.entities.Category;
import com.gymshop.entities.Product;
import com.gymshop.service.MailerService;
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
	@Autowired
	MailerService mailer;
	
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
	  @GetMapping("/account/forgot")
		public String forgot() {
			return "/client/site/forgot";
		}

		@PostMapping("/account/forgot")
		public String forgot(Model model, 
				@RequestParam("username") String username, 
				@RequestParam("email") String email) {
			try {
				Account user = accService.findById(username);
				if (!user.getEmail().equals(email)) {
					model.addAttribute("message", "Sai địa chỉ email!");
				} else {
					String message = "Mật khẩu đã được gửi qua email - Vui lòng kiểm tra bạn nhé!";
					try {
						String to = user.getEmail();
						String subject = "Lần sau đừng quên nữa nhé!";
						String body = "Mật khẩu của bạn là: " + user.getPassword();
						mailer.send(to, subject, body);
					} catch (Exception e) {
						message = "Lỗi, không gửi mật khẩu qua email!";
					}
					model.addAttribute("message", message);
				}
			} catch (Exception e) {
				model.addAttribute("message", "Sai tên đăng nhập!");
			}
			return "/client/site/forgot";
		}

		
		@GetMapping("/account/change")
		public String change(Model model, HttpServletRequest request) {
			String username = request.getRemoteUser();
			model.addAttribute("accounts", accService.findById(username));
			return "client/site/change";
		}

		@PostMapping("/account/changes")
		public String changePass(Model model, Account acc) {
			accService.save(acc);
			model.addAttribute("message", "Đổi mật khẩu thành công!");
			return "redirect:/account/change";
		}

}
