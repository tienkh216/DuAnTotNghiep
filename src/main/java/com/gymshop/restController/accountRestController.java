package com.gymshop.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gymshop.entities.Account;
import com.gymshop.entities.Category;
import com.gymshop.service.accountService;

@CrossOrigin("*")  // cho phép nhiều nơi truy cập 
@RestController // khai báo đây là controller API s
@RequestMapping("/rest/accounts")
public class accountRestController {
	@Autowired
	accountService accountService;
	
	@GetMapping("count")
	public Long GetCount() {
		return accountService.getCount();
	}
	
	
	@GetMapping()
	public List<Account> getAll(){
		return accountService.findAll();
	}
	@GetMapping("{username}")
	public Account getOne (@PathVariable("username") String username) {
		return accountService.findById(username);
	}
	
	@PostMapping()
	public Account create(@RequestBody Account account) {
		return accountService.create(account);
	}
	
	@PutMapping("{username}")
	public  Account update(@PathVariable("username") String username , @RequestBody Account account) {
		return accountService.update(account);
	}
	@DeleteMapping("{username}")
	public void delete(@PathVariable("username") String username) {
		accountService.delete(username);
	}
}
