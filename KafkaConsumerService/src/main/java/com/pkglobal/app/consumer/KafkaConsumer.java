package com.pkglobal.app.consumer;

public interface KafkaConsumer {

	public void consumeCustomerMessage(String customerJson);
}
