package com.pkglobal.app.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("unit")
public class CustomerVoTest {
	@Test
	public void testCustomerVoObjectWithSetterAndGetters() {
		CustomerVo customerVo = getCustomerVoObject();
		assertEquals(0, customerVo.getCustomerId());
		assertEquals("C0000123", customerVo.getCustomerNumber());
		assertEquals("Customer json", customerVo.getPayload());
		assertEquals(customerVo.toString(), getCustomerVoObject().toString());
	}

	private CustomerVo getCustomerVoObject() {
		CustomerVo customerVo = new CustomerVo();
		customerVo.setCustomerId(0);
		customerVo.setCustomerNumber("C0000123");
		customerVo.setPayload("Customer json");
		return customerVo;

	}
}
