package com.pkglobal.app.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pkglobal.app.model.CustomerAddress;
import com.pkglobal.app.model.CustomerRequest;
import com.pkglobal.app.model.CustomerVo;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CustomerRepositoryTest {

	@Autowired
	private TestEntityManager testEntityManager;

	@Autowired
	private CustomerRepository customerRepository;

	/**
	 * Test method to insert Customer Vo into DB
	 */
	@Test
	public void testSaveWhenValidCustomerVoPassedShouldInsertIntoDB() {
		CustomerVo customerVo = getCustomerVoObject();
		customerVo = testEntityManager.persist(customerVo);
		CustomerVo customerPayload = customerRepository.findById(customerVo.getCustomerId()).get();
		assertNotNull(customerVo);
		assertNotNull(customerPayload);
		assertThat(customerPayload).isEqualTo(customerVo);

	}

	private CustomerVo getCustomerVoObject() {
		CustomerVo customerVo = new CustomerVo();
		customerVo.setCustomerNumber("C0000123");
		customerVo.setPayload(getCustomerJson(getCustomerRequest()));
		return customerVo;

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
