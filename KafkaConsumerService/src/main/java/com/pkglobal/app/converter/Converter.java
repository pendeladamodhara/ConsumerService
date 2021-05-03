package com.pkglobal.app.converter;

import com.pkglobal.app.model.CustomerRequest;

public interface Converter {

	public CustomerRequest convert(CustomerRequest customer);
}
