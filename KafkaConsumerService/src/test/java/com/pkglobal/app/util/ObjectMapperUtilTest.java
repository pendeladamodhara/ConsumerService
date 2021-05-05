package com.pkglobal.app.util;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pkglobal.app.model.CustomerAddress;
import com.pkglobal.app.model.CustomerRequest;

public class ObjectMapperUtilTest {
	@Test
	public void testConvertJsonToJavaObjectWhenValidObjectPassedShouldreturnObject() {
		CustomerRequest customer = ObjectMapperUtil.convertJsonToJavaObject(getCustomerJson(getCustomerRequest()),
				CustomerRequest.class);
		assertNotNull(customer);
	}

	private CustomerRequest getCustomerRequest() {
		CustomerRequest customer = new CustomerRequest();
		customer.setCustomerNumber("C000000001");
		customer.setFirstName("PENDELA DAMODARA");
		customer.setLastName("CHOWDARY");
		customer.setCountry("INDIA");
		customer.setEmail("pendeladamu12@gmail.com");
		customer.setCountryCode("IN");
		customer.setMobileNumber("9492643115");
		customer.setCustomerStatus("Open");
		customer.setBirthDate("01012020");
		customer.setCustomerAddress(getCustomerAddress());
		return customer;

	}

	private CustomerAddress getCustomerAddress() {
		CustomerAddress address = new CustomerAddress();
		address.setAddressLine1("JPNAGAR");
		address.setAddressLine2("BANGALORE");
		address.setStreet("MARATHAHALLI");
		address.setPostalCode("56003");
		return address;
	}

	private String getCustomerJson(Object obj) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			return "";
		}
	}
}
