package org.entities;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
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
		} catch (JsonParseException e) {
			throw new RuntimeException("fromJson failed!",e);
		} catch (JsonMappingException e) {
			throw new RuntimeException("fromJson failed!",e);
		} catch (IOException e) {
			throw new RuntimeException("fromJson failed!",e);
		}
	}
	
	public static List fromJsonList(String input) {
		try {
			return mapper.readValue(input, new TypeReference<List<Candidate>>(){});
		} catch (JsonParseException e) {
			throw new RuntimeException("fromJson failed!",e);
		} catch (JsonMappingException e) {
			throw new RuntimeException("fromJson failed!",e);
		} catch (IOException e) {
			throw new RuntimeException("fromJson failed!",e);
		}
	}
	
	public static String toJson(Object object) {
		try {
			return mapper.defaultPrettyPrintingWriter().writeValueAsString(object);
		} catch (JsonGenerationException e) {
			throw new RuntimeException("toJson failed!",e);
		} catch (JsonMappingException e) {
			throw new RuntimeException("toJson failed!",e);
		} catch (IOException e) {
			throw new RuntimeException("toJson failed!",e);
		}
	}
}
