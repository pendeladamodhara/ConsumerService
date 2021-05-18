package com.pkglobal.app.consumer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.pkglobal.app.converter.CustomerMaskConverter;
import com.pkglobal.app.converter.CustomerVoConverter;
import com.pkglobal.app.exception.GeneralException;
import com.pkglobal.app.model.CustomerRequest;
import com.pkglobal.app.repository.CustomerRepository;
import com.pkglobal.app.util.ObjectMapperUtil;

@Service
public class KafkaCustomerConsumer implements KafkaConsumer {

	private static Logger LOGGER = LogManager.getLogger(KafkaCustomerConsumer.class);

	@Autowired
	private CustomerMaskConverter customerMaskConverter;
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	CustomerVoConverter customerVoConverter;

	@Override
	@KafkaListener(groupId = "#{'${groupId}'}", topics = "#{'${topic}'}")
	public void consumeCustomerMessage(String customerJson) {
		CustomerRequest customer = ObjectMapperUtil.convertJsonToJavaObject(customerJson, CustomerRequest.class);
		LOGGER.info("Payload received from kafka server {}", customerMaskConverter.convert(customer));
		try {
			customerRepository.save(customerVoConverter.convert(customerJson, customer.getCustomerNumber()));
		} catch (DataAccessException e) {
			throw new GeneralException("Error occurred while saving customer into DB");
		}

	}

}
