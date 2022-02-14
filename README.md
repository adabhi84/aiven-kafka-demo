The sample program in this project demonstrate how to connect to your Aiven for Apache Kafka service and pass a few messages.

**Pre-requisites:**:
1. JDK:- Java 11
2. External JARS which are being used in the impl:

		2.1 gson-2.9.0
		2.2 lz4-java-1.8.0
		2.3 slf4j-api-1.7.36
		2.4 zstd-jni-1.5.2-1
		2.5 kafka-clients-3.0.0


**Requirements:**

Keystore (client.keystore.p12) and truststore (client.truststore.jks) are properly created. For details, see our article on https://help.aiven.io/en/articles/5241419-configuring-java-ssl-to-access-kafka.

**Implementation:**

1. **Producer.java:** This class configures the secured kafka connection,kafka client serde and make a connection to kafka topic and publishes the agreement json messages to topic.
2. **Consumer.java:** This class configures the secured kafka connection,kafka client serde and make a connection to kafka topic and consumes the agreement json messages from topic which is being dumped on the console.
3. **Agreement.java:** Business Domain Model.
4. **client.keystore.p12:** Client side access key to hit the aiven kafka services.
