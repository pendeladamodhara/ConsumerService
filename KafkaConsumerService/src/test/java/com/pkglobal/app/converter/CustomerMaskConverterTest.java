package com.pkglobal.app.converter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.pkglobal.app.model.CustomerAddress;
import com.pkglobal.app.model.CustomerRequest;

@Tag("unit")
public class CustomerMaskConverterTest {

	private CustomerMaskConverter customerMaskConverter;

	@BeforeEach
	public void setUp() {
		customerMaskConverter = new CustomerMaskConverter();
	}

	/**
	 * Test method to check masking logic
	 */
	@Test
	public void testConvertWhenPassingValidCustomerObjectShouldApplyMaskingToCustomerObject() {
		CustomerRequest result = customerMaskConverter.convert(getCustomerRequest());
		assertNotNull(result);
		assertEquals("C00000****", result.getCustomerNumber());
		assertEquals("****eladamu12@gmail.com", result.getEmail());
		assertEquals("****1994", result.getBirthDate());
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
		customer.setBirthDate(LocalDate.of(1994, 06, 12).toString());
		customer.setCustomerAddress(getCustomerAddress());
		return customer;

	}

	public CustomerAddress getCustomerAddress() {
		CustomerAddress address = new CustomerAddress();
		address.setAddressLine1("JPNAGAR");
		address.setAddressLine2("BANGALORE");
		address.setStreet("MARATHAHALLI");
		address.setPostalCode("560037");
		return address;
	}
}
