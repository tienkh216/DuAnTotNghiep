package com.gymshop;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {
	@Bean
	public JavaMailSender getJavaMailSender() {
		JavaMailSenderImpl sender = new JavaMailSenderImpl();
		sender.setHost("smtp.gmail.com");
		sender.setPort(587);
		//active send mail https://myaccount.google.com/lesssecureapps
		sender.setUsername("thonghhps11306@fpt.edu.vn");
		sender.setPassword("P@ssw0rd");
		Properties props = sender.getJavaMailProperties();
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.smtp.starttls.enable", "true");
		props.setProperty("mail.debug", "true");
		return sender;

	}
}
