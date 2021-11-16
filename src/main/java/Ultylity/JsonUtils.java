package Ultylity;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {
	private static ObjectMapper mapper = new ObjectMapper();
	/**
	 * Chuyển đổi object thành chuỗi JSON
	 * @param obj đổi tượng cần chuyển đổi
	 * @return chuỗi JSON đã chuyển đổi
	 */
	public static String fromObject(Object obj){
		try {
			return mapper.writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * Chuyển đổi chuỗi JSON thành object
	 * @param json chuỗi JSON cần chuyển đổi
	 * @param clazz kiểu của đối tượng cần chuyển đổi
	 * @return đối tượng đã chuyển đổi
	 */
	public static <T> T toObject(String json, Class<T> clazz){
		try {
			return mapper.readValue(json, clazz);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}