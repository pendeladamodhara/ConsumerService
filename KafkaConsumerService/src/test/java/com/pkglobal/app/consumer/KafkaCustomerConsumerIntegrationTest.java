package com.pkglobal.app.consumer;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.kafka.test.EmbeddedKafkaBroker;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.kafka.test.utils.ContainerTestUtils;
import org.springframework.kafka.test.utils.KafkaTestUtils;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@EmbeddedKafka
@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class KafkaCustomerConsumerIntegrationTest {

	private static final String TOPIC = "customer";

	@Autowired
	private EmbeddedKafkaBroker embeddedKafkaBroker;

	BlockingQueue<ConsumerRecord<String, String>> consumerRecords;

	KafkaMessageListenerContainer<String, String> kafkaMessageListenerContainer;

	@BeforeAll
	public void setUp() {
		Map<String, Object> configs = new HashMap<>(
				KafkaTestUtils.consumerProps("consumer", "false", embeddedKafkaBroker));
		DefaultKafkaConsumerFactory<String, String> consumerFactory = new DefaultKafkaConsumerFactory<>(configs,
				new StringDeserializer(), new StringDeserializer());
		ContainerProperties containerProperties = new ContainerProperties(TOPIC);
		kafkaMessageListenerContainer = new KafkaMessageListenerContainer<>(consumerFactory, containerProperties);
		consumerRecords = new LinkedBlockingQueue<>();
		kafkaMessageListenerContainer.setupMessageListener((MessageListener<String, String>) consumerRecords::add);
		kafkaMessageListenerContainer.start();
		ContainerTestUtils.waitForAssignment(kafkaMessageListenerContainer,
				embeddedKafkaBroker.getPartitionsPerTopic());
	}

	@Test
	public void testKafkaSetupwithTopicShouldSendMessageAndReceived() throws Exception {
		Map<String, Object> configs = new HashMap<>(KafkaTestUtils.producerProps(embeddedKafkaBroker));
		Producer<String, String> producer = new DefaultKafkaProducerFactory<>(configs, new StringSerializer(),
				new StringSerializer()).createProducer();
		producer.send(new ProducerRecord<>(TOPIC, "my-aggregate-id", "{\"event\":\"Test Event\"}"));
		producer.flush();
		ConsumerRecord<String, String> singleRecord = consumerRecords.poll(100, TimeUnit.MILLISECONDS);
		assertThat(singleRecord).isNotNull();
		assertThat(singleRecord.key()).isEqualTo("my-aggregate-id");
		assertThat(singleRecord.value()).isEqualTo("{\"event\":\"Test Event\"}");
	}

	@AfterAll
	void tearDown() {
		kafkaMessageListenerContainer.stop();
	}
}
