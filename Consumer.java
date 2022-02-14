package com.aiven.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Arrays;
import java.util.Properties;

public class Consumer {

    public static void main(String[] args) {

        Properties props = new Properties();
        props.put("bootstrap.servers", "anant-aiven-demo-macquarie-d507.aivencloud.com:26411");
        props.put("security.protocol", "SSL");
        props.put("ssl.truststore.location", "client.truststore.jks");
        props.put("ssl.truststore.password", "test123");
        props.put("ssl.keystore.type", "PKCS12");
        props.put("ssl.keystore.location", "client.keystore.p12");
        props.put("ssl.keystore.password", "test123");
        props.put("ssl.key.password", "test123");
        props.put("group.id", "anant-demo-group");
        props.put("key.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList("anant-demo-topic"));
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(1000);
            for (ConsumerRecord<String, String> record : records) {
                if(record.key() != null){

                System.out.printf("offset = %d, key = %s, value = %s",
                        record.offset(), record.key(), record.value());
            }}
        }




    }
}
