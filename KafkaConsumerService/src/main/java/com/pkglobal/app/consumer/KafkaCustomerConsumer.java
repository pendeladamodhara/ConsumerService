package com.pkglobal.app.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.pkglobal.app.converter.CustomerMaskConverter;
import com.pkglobal.app.converter.CustomerVoConverter;
import com.pkglobal.app.model.CustomerRequest;
import com.pkglobal.app.repository.CustomerRepository;
import com.pkglobal.app.util.ObjectMapperUtil;

@Service
public class KafkaCustomerConsumer implements KafkaConsumer {

	public static final Logger LOGGER = LoggerFactory.getLogger(KafkaCustomerConsumer.class);
	@Autowired
	private CustomerMaskConverter customerMaskConverter;
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	CustomerVoConverter customerVoConverter;

	@Override
	@KafkaListener(groupId = "customer-1", topics = "customer")
	public void consumeCustomerMessage(String customerJson) {
		CustomerRequest customer = ObjectMapperUtil.convertJsonToJavaObject(customerJson, CustomerRequest.class);
		LOGGER.info("Payload received from kafka server {}", customerMaskConverter.convert(customer));

		System.out.println(
				customerRepository.save(customerVoConverter.convert(customerJson, customer.getCustomerNumber())));
		// customerRepository.save(customerVoConverter.convert(customerJson,
		// customer.getCustomerNumber()));
	}

}
