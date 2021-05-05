package com.pkglobal.app.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("unit")
public class ErrorLogTest {

	@Test
	public void testErrorLogObjectWithSetterAndGetters() {
		ErrorLog errorLog = getErrorLogObject();
		assertEquals(0, errorLog.getErrorid());
		assertEquals("KafkaConsumerException", errorLog.getErrorType());
		assertEquals("Exception while consuming message from kafka", errorLog.getErrorDesc());
		assertEquals("Customer json", errorLog.getPayload());
		assertEquals(errorLog.toString(), getErrorLogObject().toString());
	}

	private ErrorLog getErrorLogObject() {
		ErrorLog customerVo = new ErrorLog();
		customerVo.setErrorid(0);
		customerVo.setErrorType("KafkaConsumerException");
		customerVo.setErrorDesc("Exception while consuming message from kafka");
		customerVo.setPayload("Customer json");
		return customerVo;

	}
}
