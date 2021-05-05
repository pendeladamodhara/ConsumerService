package com.pkglobal.app.kafka.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.errors.TimeoutException;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.RecoverableDataAccessException;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

@Configuration
@EnableKafka
public class KafkaConsumerConfiguration {

	public static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumerConfiguration.class);

	@Bean
	public ConsumerFactory<String, String> customerConsumerFactory() {
		Map<String, Object> configs = new HashMap<>();
		configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		configs.put(ConsumerConfig.GROUP_ID_CONFIG, "customer-1");
		return new DefaultKafkaConsumerFactory<>(configs, new StringDeserializer(), new StringDeserializer());
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(customerConsumerFactory());
		factory.setRetryTemplate(retryTemplate());
		factory.setRecoveryCallback((context -> {

			if (context.getLastThrowable().getCause() instanceof RecoverableDataAccessException) {
			} else {
				throw new RuntimeException(context.getLastThrowable().getMessage());
			}
			return null;
		}));
		factory.setErrorHandler(((exception, data) -> {
			LOGGER.error("Error in process with Exception {} and the record is {}", exception, data);
		}));

		return factory;
	}

	private RetryTemplate retryTemplate() {
		RetryTemplate retryTemplate = new RetryTemplate();
		retryTemplate.setRetryPolicy(getSimpleRetryPolicy());
		return retryTemplate;
	}

	private SimpleRetryPolicy getSimpleRetryPolicy() {
		Map<Class<? extends Throwable>, Boolean> exceptionMap = new HashMap<>();
		exceptionMap.put(IllegalArgumentException.class, false);
		exceptionMap.put(TimeoutException.class, true);
		return new SimpleRetryPolicy(3, exceptionMap, true);
	}

}
