package com.gymshop.controller;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.gymshop.entities.Account;
import com.gymshop.service.AccountService;
import com.gymshop.service.CookieService;
import com.gymshop.service.MailerService;
import com.gymshop.service.SessionService;

import Ultylity.JsonUtils;
import Ultylity.StrUtils;


@Controller
@SessionAttributes("fullname")

@RequestMapping("/account")
@CrossOrigin
public class AccountController {
	@Autowired
	AccountService accountService;
	
	@Autowired
	CookieService cookie;
	
	@Autowired
	SessionService session;
	
	@Autowired
	MailerService mailer;
	
	
	 
	@GetMapping("/login")
	public String login(ModelMap model) {
		String value = cookie.getValue("user", "");
		if(value.length() > 0) {
			String json = StrUtils.decode64(value);
			model.addAttribute("map", JsonUtils.toObject(json, Map.class));	
		}
		else {
			model.addAttribute("map", null);
		}
		return "admin/login";
	}
	@PostMapping("/login")
	public String login(ModelMap model, 
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			@RequestParam(name = "remember", defaultValue = "false") boolean remember) {
			
		try {
			
			Account user = accountService.checkAccount(username, password);
			System.out.println(user);

			if(user == null) {
				model.addAttribute("message", "Sai mật khẩu hoặc tài khoản");
				return "admin/login";
			}
			else {
				
				session.addUser(user);
				return "redirect:/client/home";
				
			}
		} catch (Exception e) {
			model.addAttribute("message", "Sai tên đăng nhập");
			return "redirect:/account/login";
		}

	}
	
	////////////////////////logout//////////////////////////////////////////////////
	@GetMapping("/logoff")
	public String logoff() {
		session.removeUser();
		cookie.delete("JSESSIONID");
		return "redirect:/account/login";
	} 
	
	/////////////// forgot password ////////////////////////////
	@GetMapping("/forgot")
	public String forgot() {
		return "views/quenmk.html";
	}
	@PostMapping("/forgot")
	public String forgot(ModelMap model, 
			@RequestParam("username") String username,
			@RequestParam("email") String email) {
		try {
			Account user = accountService.checkAccountbyUsername(username);
			if(!user.getActivated()) {
				model.addAttribute("message", "Tài khoản chưa kích hoạt");
			}
			else if(!user.getEmail().equals(email)) {
				model.addAttribute("message", "Sai địa chỉ email");
			}
			else {
				
				 // Gửi mật khẩu qua email
				 
				String message = "Mật khẩu của bạn đã được gửi qua email!";
				try {
					String to = user.getEmail();
					String subject = "Poly Capstone Project - Forgot password";
					String body = "Mật khẩu của bạn là:  " + user.getPassword();
					mailer.send(to, subject, body);
				} catch (Exception e) {
					message = "Lỗi, không gửi mật khẩu qua email!";
				}
				model.addAttribute("message", message);
			}
		} catch (Exception e) {
			model.addAttribute("message", "Sai tên đăng nhập");
		}
		return "views/login";
	}
	
/////////////// dang ky ////////////////////////////
	@GetMapping("/register")
	public String register(ModelMap model) {
		model.addAttribute("form", new Account());
		return "views/dangki";
	}
	@PostMapping("/register")
	public String register(ModelMap model, 
			@ModelAttribute("form") Account user, 
			HttpServletRequest request) {
		Account account = accountService.checkAccountbyUsername(user.getUsername());
		if(account != null) {
			model.addAttribute("message", "Tài khoản đã tồn tại !!!");
		}
		else {
			/*
			 *  Gửi mail kích hoạt tài khoản
			 */
			user.setActivated(true);
			user.setAdmin(false);
			accountService.addAccount(user);
			String message = "Đăng ký thành công. Vui lòng kích hoạt qua email!";
			try {
				String activateUrl = request.getRequestURL().toString().replace("register", "login/");
				String to = user.getEmail();
				String subject = "The B Coffee Store - Account Activation Email";
				String body = "Bấm vào <a href='"+activateUrl+"'>ĐÂY</a> để kích hoạt tài khoản!";
				mailer.send(to, subject, body);
				
			} catch (Exception e) {
				message = "Lỗi, không gửi được email kích hoạt!";
			}
			model.addAttribute("message", message);
		}
		return "views/dangki";
	}
	// send mail kich hoat ////////////////////////////////
	
	@GetMapping("/account/activate/{id}")
	public String activate(@PathVariable("id") Long id) {
		String message = "";
		try {
			Account user = accountService.getAccount(id);
			user.setActivated(true);
			accountService.addAccount(user);
		} catch (Exception e) {
			message = "Lỗi: Không thể kích hoạt được tài khoản!";
		}
		return "redirect:/account/login?message=" + StrUtils.encodeUrl(message);
	}
	
/////////////////////////////////// cap nhat infor user ////////////////////////////////////////////

//	@GetMapping("/edit")
//	public String edit(ModelMap model) {
//		model.addAttribute("form", new Account());
//		model.addAttribute("form", session.getUser());
//		return "views/edit";
//	}
	
	@GetMapping("/edit")
	public String getbyID(ModelMap model) {	
		//model.addAttribute("form", session.getUser());
		Account account = session.getUser();
//		Account account = accountService.checkAccountbyUsername(username);
		model.addAttribute("form", session.getUser());
		session.getUser();
		if(account != null) {
			return "views/edit";
		}
		return "views/edit";
	}
	
	
	@PostMapping("/edit")
	public String edit(ModelMap model, @ModelAttribute("form") Account user) {
//		Account account = accountService.checkAccountbyUsername(username);
//		Account account = accountService.getAccount(id);
//		if(account == null) {
//			model.addAttribute("message", "Tài khoản không tồn tại!");	
//		}
//		else {
			user.setId(session.getUser().getId());
			user.setUsername(user.getUsername());
			user.setPassword(user.getPassword());
			user.setFullname(user.getFullname());
			user.setAddress(user.getAddress());
			user.setPhone(user.getPhone());
			user.setEmail(user.getEmail());
			user.setActivated(true);
			user.setAdmin(user.getAdmin());
			
			accountService.updateAccount(user);
			session.removeUser();
			session.addUser(user);
			
			model.addAttribute("message", "Cập nhật tài khoản thành công");
//		}
		return "views/edit";
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		
	// admin
		@GetMapping("/list")
		public ResponseEntity<List<Account>> findAllUser() {
			List<Account> account = accountService.getAll();
			return new ResponseEntity<List<Account>>(account, HttpStatus.OK);
		};

		@GetMapping("/list/{id}")
		public ResponseEntity<?> findById(@PathVariable("id") Long id) {
			Account prods = accountService.getAccount(id);
			if (prods != null) {
				return new ResponseEntity<Account>(prods, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

		};
		//Add mới 
	    @PostMapping("/create")
	    public ResponseEntity<?> addAccount(@RequestBody Account account) {
	    	Account us = accountService.checkAccountbyUsername(account.getUsername());
			if (us != null) {
				throw new RuntimeException("Username đã tồn tại, vui lòng nhập username khác!");
			} else {
				accountService.addAccount(account);
				return new ResponseEntity<Account>(HttpStatus.OK);
			}
	    }
		
		@PutMapping("/update/{id}")
		public ResponseEntity<Account> updateAccount(@PathVariable("id") Long id, @RequestBody Account account ){
				Account info = accountService.getAccount(id);
				if(info != null){
					info.setUsername(account.getUsername());
					info.setPassword(account.getPassword());
					info.setFullname(account.getFullname());
					info.setAddress(account.getAddress());
					info.setPhone(account.getPhone());
					info.setEmail(account.getEmail());
					info.setActivated(account.getActivated());
					info.setAdmin(account.getAdmin());
					accountService.updateAccount(info);
					return new ResponseEntity<Account>(info, HttpStatus.OK);
				}else{
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}
					
			}
		
		//xóa 
	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
	        Account dataStd = accountService.getAccount(id);
	        if (dataStd == null) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        } else {
	        	accountService.deleteAccount(id);
	            return new ResponseEntity<>(HttpStatus.OK);
	        }
	    }
	    //login
	    @PostMapping("/loginAdmin")
		public ResponseEntity<Account> loginAdmin(@RequestParam("username") String username,
				@RequestParam("password") String password) {
			Account user = accountService.checkAccountAdmin(username, password);
			if(user != null) {
				return new ResponseEntity<Account>(user, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
}

