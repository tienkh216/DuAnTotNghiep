package Ultylity;

import java.net.URLEncoder;
import java.util.Base64;
import java.util.UUID;

public class StrUtils {
	/**
	 * Mã hóa chuỗi dạng Base64
	 * @param text chuỗi cần mã hóa
	 * @return chuỗi đã mã hóa
	 */
	public static String encode64(String text) {
		return Base64.getEncoder().encodeToString(text.getBytes());
	}
	/**
	 * Giải mã chuỗi mã hóa dạng Base64
	 * @param encodedText chuỗi cần giải mã
	 * @return chuỗi đã giải mã
	 */
	public static String decode64(String encodedText) {
		return new String(Base64.getDecoder().decode(encodedText));
	}
	/**
	 * Mã hóa URL để redirect 
	 * @param queryString chuỗi cần mã hóa
	 * @return chuỗi đã mã hóa
	 */
	public static String encodeUrl(String queryString) {
		try {
			return URLEncoder.encode(queryString, "utf-8");
		} catch (Exception e) {
			return queryString;
		}
	}
	/**
	 * Lấy chuỗi duy nhất ngẫu nhiên hệ 16
	 */
	public static String getId() {
		return Integer.toHexString(UUID.randomUUID().hashCode());
	}
}