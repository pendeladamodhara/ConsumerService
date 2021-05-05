package com.pkglobal.app.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.pkglobal.app.entity.Customer;

@Tag("unit")
public class CustomerTest {
	@Test
	public void testCustomerVoObjectWithSetterAndGetters() {
		Customer customerVo = getCustomerVoObject();
		assertEquals(0, customerVo.getCustomerId());
		assertEquals("C0000123", customerVo.getCustomerNumber());
		assertEquals("Customer json", customerVo.getPayload());
		assertEquals(customerVo.toString(), getCustomerVoObject().toString());
	}

	private Customer getCustomerVoObject() {
		Customer customerVo = new Customer();
		customerVo.setCustomerId(0);
		customerVo.setCustomerNumber("C0000123");
		customerVo.setPayload("Customer json");
		return customerVo;

	}
}
