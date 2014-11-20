package org.entities;

import java.io.IOException;
import java.util.List;


import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

public final class JSON {
	
	private JSON() {
		// nope
	}
	
	private static ObjectMapper mapper = new ObjectMapper();
	
	public static <T> T fromJson(String input, Class<T> clazz) {
		try {
			return mapper.readValue(input, clazz);
		} catch (Exception e) {
			throw new RuntimeException("fromJson failed!",e);
		}
	}
	
	public static List fromJsonList(String input) {
		try {
			return mapper.readValue(input, new TypeReference<List<Candidate>>(){});
		} catch (Exception e) {
			throw new RuntimeException("fromJson failed!",e);
		}
	}
	
	public static String toJson(Object object) {
		try {
			return mapper.defaultPrettyPrintingWriter().writeValueAsString(object);
		} catch (Exception e) {
			throw new RuntimeException("toJson failed!",e);
		} 
	}
}
