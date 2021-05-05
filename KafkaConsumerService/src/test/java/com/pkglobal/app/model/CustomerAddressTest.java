package com.pkglobal.app.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("unit")
public class CustomerAddressTest {
	@Test
	public void testCustomerAddressObjectWithSetterAndGetters() {
		CustomerAddress address = getCustomerAddress();
		assertEquals("JPNAGAR", address.getAddressLine1());
		assertEquals("BANGALORE", address.getAddressLine2());
		assertEquals("MARATHAHALLI", address.getStreet());
		assertEquals("56003", address.getPostalCode());
		assertEquals(getCustomerAddress().hashCode(), address.hashCode());
		assertTrue(getCustomerAddress().equals(address));
		assertEquals(getCustomerAddress().toString(), address.toString());

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
