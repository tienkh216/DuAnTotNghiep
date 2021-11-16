package com.gymshop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.gymshop.entities.Account;
import com.gymshop.service.SessionService;

import Ultylity.StrUtils;

@Component
public class SecurityInterceptor implements HandlerInterceptor {
	@Autowired
	SessionService session;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String uri = request.getRequestURI() + "?" + request.getQueryString();
		Account user = session.getUser();
		String error = "";
		if(user == null) {
			error = "Vui lòng đăng nhập trước khi sử dụng chức năng này!";
		}
		else if(user.getAdmin() == false && uri.startsWith("/admin/")) {
			 error = "Bạn không có quyền sử dụng chức năng này!";
		 }
		/*-- Không lỗi -> cho phép truy xuất --*/
		if(error.length() == 0) {
			return true;
		}
		/*-- Có lỗi -> về đăng nhập --*/
		session.addSecurityUrl(uri);
		response.sendRedirect("/account/login?message=" + StrUtils.encodeUrl(error) );
		return false;
	}
}