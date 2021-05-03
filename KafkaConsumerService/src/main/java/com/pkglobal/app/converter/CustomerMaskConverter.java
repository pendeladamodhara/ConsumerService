package com.pkglobal.app.converter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

import com.pkglobal.app.constants.ConsumerConstants;
import com.pkglobal.app.model.CustomerRequest;

@Service
public class CustomerMaskConverter implements Converter {

	@Override
	public CustomerRequest convert(CustomerRequest input) {

		CustomerRequest customer = new CustomerRequest();
		customer.setCustomerNumber(input.getCustomerNumber().replaceAll(ConsumerConstants.CUSTOMER_NUMBER_MASK,
				ConsumerConstants.ASTERISK));
		customer.setFirstName(input.getFirstName());
		customer.setLastName(input.getLastName());
		customer.setCountry(input.getCountry());
		customer.setCountryCode(input.getCountryCode());
		customer.setEmail(
				input.getEmail().replaceAll(ConsumerConstants.FIRST_FOUR_CHARACTERS_MASK, ConsumerConstants.ASTERISKS));
		customer.setMobileNumber(input.getMobileNumber());
		customer.setCustomerStatus(input.getCustomerStatus());
		customer.setBirthDate(
				LocalDate.parse(input.getBirthDate()).format(DateTimeFormatter.ofPattern(ConsumerConstants.ddMMyyyy))
						.replaceAll(ConsumerConstants.FIRST_FOUR_CHARACTERS_MASK, ConsumerConstants.ASTERISKS));
		customer.setCustomerAddress(input.getCustomerAddress());
		return customer;
	}

}
