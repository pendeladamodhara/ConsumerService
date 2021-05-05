package com.pkglobal.app.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("unit")
public class CustomerRequestTest {
	@Test
	public void testCustomerRequestObjectWithSetterAndGetters() {
		CustomerRequest customer = getCustomerRequest();
		assertEquals("C000000001", customer.getCustomerNumber());
		assertEquals("PENDELA DAMODARA", customer.getFirstName());
		assertEquals("CHOWDARY", customer.getLastName());
		assertEquals("INDIA", customer.getCountry());
		assertEquals("pendeladamu12@gmail.com", customer.getEmail());
		assertEquals("IN", customer.getCountryCode());
		assertEquals("9492643115", customer.getMobileNumber());
		assertEquals("Open", customer.getCustomerStatus().toString());
		assertEquals("01012020", customer.getBirthDate());
		assertEquals(getCustomerRequest().toString(), customer.toString());
		assertEquals(getCustomerRequest().hashCode(), customer.hashCode());
		assertTrue(getCustomerRequest().equals(customer));

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
}
