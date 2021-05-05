package com.pkglobal.app.converter;

import org.springframework.stereotype.Service;

import com.pkglobal.app.entity.Customer;

@Service
public class CustomerVoConverter {

	public Customer convert(String customerJson, String customerNumber) {
		Customer customerVo = new Customer();
		customerVo.setCustomerNumber(customerNumber);
		customerVo.setPayload(customerJson);
		return customerVo;
	}
}
