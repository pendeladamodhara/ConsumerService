package com.pkglobal.app.converter;

import org.springframework.stereotype.Service;

import com.pkglobal.app.model.CustomerVo;

@Service
public class CustomerVoConverter {

	public CustomerVo convert(String customerJson, String customerNumber) {
		CustomerVo customerVo = new CustomerVo();
		customerVo.setCustomerNumber(customerNumber);
		customerVo.setPayload(customerJson);
		return customerVo;
	}
}
