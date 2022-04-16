package com.jforce.tr.jsonbase;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonWebServiceClientBase {

	protected ObjectMapper mapper;
	
	public JsonWebServiceClientBase() {
		mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
	}
}
