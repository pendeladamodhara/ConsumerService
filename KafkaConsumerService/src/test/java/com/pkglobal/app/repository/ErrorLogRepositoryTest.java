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
import com.pkglobal.app.entity.ErrorLog;
import com.pkglobal.app.model.CustomerAddress;
import com.pkglobal.app.model.CustomerRequest;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ErrorLogRepositoryTest {

	@Autowired
	private TestEntityManager testEntityManager;

	@Autowired
	private ErrorLogRepository errorLogRepository;

	/**
	 * Test method to save Error Log object into DB
	 */
	@Test
	public void testSaveWhenValidErrorLogPassedShouldInsertIntoDB() {

		ErrorLog errorLog = getErrorLogObject();
		errorLog = testEntityManager.persist(errorLog);
		ErrorLog savedErrorLog = errorLogRepository.findById(errorLog.getErrorid()).get();
		assertNotNull(errorLog);
		assertNotNull(savedErrorLog);
		assertThat(errorLog).isEqualTo(savedErrorLog);
	}

	private ErrorLog getErrorLogObject() {
		ErrorLog customerVo = new ErrorLog();
		customerVo.setErrorid(0);
		customerVo.setErrorType("KafkaConsumerException");
		customerVo.setErrorDesc("Exception while consuming message from kafka");
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
