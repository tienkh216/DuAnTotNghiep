package com.gymshop.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gymshop.entities.Account;
@Service
public class SessionService {
	@Autowired
	HttpSession session;
	/**
	 * Đọc user từ session
	 */
	public Account getUser() {
		return (Account) session.getAttribute("user");
	}
	/**
	 * Lưu user vào session
	 */
	public void addUser(Account user) {
		
		session.setAttribute("user", user);
		session.setAttribute("fullname", user.getFullname());
		session.setAttribute("id", user.getId());
	}
	/**
	 * Xóa user khỏi session
	 */
	public void removeUser() {
		session.removeAttribute("user");
		session.removeAttribute("fullname");
	}
	/**
	 * Đọc security-url từ session
	 */
	public String getSecurityUrl() {
		return (String) session.getAttribute("security-url");
	}
	/**
	 * Lưu security-url vào session
	 */
	public void addSecurityUrl(String securityUrl) {
		session.setAttribute("security-url", securityUrl);
	}
	/**
	 * Xóa security-url khỏi session
	 */
	public void removeSecurityUrl() {
		session.removeAttribute("security-url");
	}
	/**
	 * Hủy bỏ session hiện tại
	 */
	public void clear() {
		session.invalidate();
	}
}
