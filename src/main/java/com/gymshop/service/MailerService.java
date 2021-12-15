package com.gymshop.service;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailerService {
	@Autowired
	JavaMailSender sender;

	/**
	 * Gửi mail
	 * 
	 * @param to      email người nhận
	 * @param subject tiêu đề email
	 * @param body    nội dung email
	 * @param others  các thông số email khác
	 *                <ol start="0">
	 *                <li>From: email người gửi</li>
	 *                <li>CC: các email cùng nhận, phân cách bởi dấu [,; ]</li>
	 *                <li>BCC: các email ẩn danh cùng nhận, phân cách bởi dấu [,;
	 *                ]</li>
	 *                <li>Attachment files: các file đính kèm, phân cách bởi dấu
	 *                [,;]</li>
	 *                </ol>
	 * @exception lỗi không gửi được email
	 */
	public void send(String to, String subject, String body, String... others) {
		try {
			MimeMessage mail = sender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mail, true, "utf-8");
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(body, true);

			String from = this.getOtherAt(0, others);
			if (from.length() == 0) {
				from = "VDPKGL <vdpkgl@gmail.com>";
			} else {
				from = String.format("%s <%s>", from, from);
			}
			helper.setFrom(from);
			helper.setReplyTo(from);

			String cc = this.getOtherAt(1, others);
			if (cc.length() > 0) {
				helper.setCc(cc.split("[,; ]+"));
			}
			String bcc = this.getOtherAt(2, others);
			if (bcc.length() > 0) {
				helper.setBcc(bcc.split("[,; ]+"));
			}
			String files = this.getOtherAt(3, others);
			if (files.length() > 0) {
				for (String path : files.split("[,;]+")) {
					File file = new File(path);
					helper.addAttachment(file.getName(), file);
				}
			}
			sender.send(mail);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Lấy giá trị từ mảng đối số còn lại (others)
	 * 
	 * @param index  vị trí của phần tử trong others
	 *               <ol start="0">
	 *               <li>From email
	 *               <li>CC emails
	 *               <li>BCC emails
	 *               <li>Attachment files
	 *               </ol>
	 * @param others mảng đối số others
	 */
	private String getOtherAt(int index, String... others) {
		if (others.length > index && others[index] != null) {
			return others[index];
		}
		return "";
	}
}
