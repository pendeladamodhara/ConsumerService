package com.pkglobal.app.consumer;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pkglobal.app.converter.CustomerMaskConverter;
import com.pkglobal.app.converter.CustomerVoConverter;
import com.pkglobal.app.model.CustomerAddress;
import com.pkglobal.app.model.CustomerRequest;
import com.pkglobal.app.model.CustomerVo;
import com.pkglobal.app.repository.CustomerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KafkaCustomerConsumerTest {

	@Autowired
	private KafkaCustomerConsumer kafkaCustomerConsumer;

	@MockBean
	private CustomerMaskConverter customerMaskConverter;
	@MockBean
	private CustomerRepository customerRepository;
	@MockBean
	CustomerVoConverter customerVoConverter;

	@Test
	public void testconsumeCustomerMessageWhenKafkaMessageReceivedShouldExcecute() {

		Mockito.when(customerMaskConverter.convert(getCustomerRequest())).thenReturn(getCustomerRequest());
		Mockito.when(customerVoConverter.convert(getCustomerJson(getCustomerRequest()),
				getCustomerRequest().getCustomerNumber())).thenReturn(getCustomerVoObject());
		Mockito.when(customerRepository.save(getCustomerVoObject())).thenReturn(getCustomerVoObject());
		kafkaCustomerConsumer.consumeCustomerMessage(getCustomerJson(getCustomerRequest()));
		assertNotNull(customerMaskConverter);
		assertNotNull(customerVoConverter);
		assertNotNull(kafkaCustomerConsumer);
		assertNotNull(customerRepository);
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

	public CustomerVo getCustomerVoObject() {
		CustomerVo customerVo = new CustomerVo();
		customerVo.setCustomerNumber("C000000001");
		customerVo.setPayload(getCustomerJson(getCustomerRequest()));
		return customerVo;
	}

}
