package kafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class ProducerExample {

	public static void main(String[] args) {
		
		String BOOT_STRAP_SERVER = "localhost:9092";
		String TOPIC = "test-topic";
		
		//create properties
		Properties properties = new Properties();
		properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOT_STRAP_SERVER);
		properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		
		//create kafka producer and add properties
		KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);
		
		//create producer record
		ProducerRecord<String, String> record = new ProducerRecord<String, String>(TOPIC, "Hello, World. this is my first record using java client");
		
		//then send data then flush then close
		producer.send(record);
		producer.flush();
		producer.close();


	}

}
