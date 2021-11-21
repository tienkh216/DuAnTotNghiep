package com.gymshop.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gymshop.entities.Account;
import com.gymshop.service.accountService;

@CrossOrigin("*")  // cho phép nhiều nơi truy cập 
@RestController // khai báo đây là controller API s
@RequestMapping("/rest/accounts")
public class accountRestController {
	@Autowired
	accountService accountService;
	@GetMapping()
	public List<Account> getAll(){
		return accountService.findAll();
	}
}
