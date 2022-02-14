package com.aiven.kafka.publisher;

import com.google.gson.Gson;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.Future;

public class Producer {

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
        props.put("key.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        Agreement agreement = new Agreement();
        agreement.setAgreementId(UUID.randomUUID());
        agreement.setAgreementName("ISDA Master");
        agreement.setAgreementType("OTC");
        agreement.setAgreementStatus("Preparation");
        agreement.setCounterPartyLongName("Goldman Sachs LLC");
        agreement.setCreated(ZonedDateTime.now(ZoneOffset.UTC).format(DateTimeFormatter.ISO_INSTANT));
        KafkaProducer<String, String> producer = new KafkaProducer<>(props);
        String jsonString = new Gson().toJson(agreement);
        System.out.println(jsonString);
        Future<RecordMetadata> tt = producer.send(new ProducerRecord("anant-demo-topic", agreement.getAgreementId().toString(), jsonString));
        System.out.println(tt);
        producer.close();
        System.out.println("Completed");
    }
}
