package com.pkglobal.app.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperUtil<T> {

	private ObjectMapperUtil() {
	}

	public static <T> T convertJsonToJavaObject(String json, Class<T> cls) {
		T response = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			response = mapper.readValue(json, cls);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return response;

	}

}
