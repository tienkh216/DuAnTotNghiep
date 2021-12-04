package com.gymshop;

import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.gymshop.entities.Account;
import com.gymshop.service.accountService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	accountService AccountService;
	@Autowired
	BCryptPasswordEncoder pe;
	
	// cung cấp nguồn dữ liệu
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(username ->{
			try {
				Account user = AccountService.findById(username);
				String password = pe.encode(user.getPassword());
				String[] roles = user.getAuthorities().stream()
						.map(er ->er.getRole().getId())
						.collect(Collectors.toList()).toArray(new String[0]);
				return User.withUsername(username).password(password).roles(roles).build();
			} catch (NoSuchElementException e) {
				throw new UsernameNotFoundException(username +  "not found");	
			}
		});
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests()
			.antMatchers("/client/checkout/**").authenticated()
			.antMatchers("/admin/**").hasAnyRole("STAF","DIRE")
			.antMatchers("/rest/authorities").hasRole("DIRE")
			.antMatchers("/rest/products").hasAnyRole("STAF","DIRE")
			.antMatchers("/rest/products/status").hasAnyRole("STAF","DIRE")
			.antMatchers("/rest/products/{id}").hasAnyRole("DIRE")
			
			.antMatchers("/rest/categories").hasAnyRole("STAF","DIRE")
			.antMatchers("/rest/categories/{id}").hasAnyRole("DIRE")
			
			.antMatchers("/rest/orderdetail").hasAnyRole("STAF","DIRE")
			.antMatchers("/rest/orders").hasAnyRole("STAF","DIRE")
			
			.antMatchers("/rest/orders/status").hasAnyRole("STAF","DIRE")
			.antMatchers("/rest/accounts").hasAnyRole("DIRE")
			.anyRequest().permitAll();
		
		http.formLogin()
			.loginPage("/login/form")
			.loginProcessingUrl("/login")
			.defaultSuccessUrl("/login/success",false)
			.failureUrl("/login/error");
		
		http.rememberMe()
			.tokenValiditySeconds(86400);
	
		http.exceptionHandling()
			.accessDeniedPage("/login/unauthoried");
		
		http.logout()
			.logoutUrl("/login/logoff")
			.logoutSuccessUrl("/login/logoff/sucess");
		
	}
	@Bean
	public BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(HttpMethod.OPTIONS,"/**");
	}
}
