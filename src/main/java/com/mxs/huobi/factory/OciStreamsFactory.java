package com.mxs.huobi.factory;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class OciStreamsFactory {
    private static final String BOOTSTRAP_SERVERS = "bootstrap.servers";
    private static final String SASL_JAAS_CONFIG = "sasl.jaas.config";
    private static final String MAX_REQUEST_SIZE = "max.request.size";
    private static final String RETRIES = "retries";
    private static final String GROUP_ID = "group.id";
    private static final String ENABLE_AUTO_COMMIT = "enable.auto.commit";
    private static final String SESSION_TIMEOUT_MS = "session.timeout.ms";
    private static final String AUTO_OFFSET_RESET = "auto.offset.reset";
    private static final String SECURITY_PROTOCOL = "security.protocol";
    private static final String SASL_MECHANISM = "sasl.mechanism";

    @Value("${oracle.oci.streaming.bootstrap-servers}")
    private String bootstrapServers;
    @Value("${oracle.oci.streaming.sasl-jaas-config}")
    private String saslJaasConfig;
    @Value("${oracle.oci.streaming.max-request-size}")
    private String maxRequestSize;
    @Value("${oracle.oci.streaming.retries}")
    private String retries;
    @Value("${oracle.oci.streaming.group-id}")
    private String groupId;
    @Value("${oracle.oci.streaming.enable-auto-commit}")
    private String enableAutoCommit;
    @Value("${oracle.oci.streaming.session-timeout-ms}")
    private String sessionTimeoutMs;
    @Value("${oracle.oci.streaming.auto-offset-reset}")
    private String autoOffsetReset;
    @Value("${oracle.oci.streaming.security.protocol}")
    private String protocol;
    @Value("${oracle.oci.streaming.sasl.mechanism}")
    private String mechanism;
    @Value("${oracle.oci.streaming.pool.mxs-huobi-module}")
    private String mxsHuobiModulePool;
    @Value("${oracle.oci.profile.username}")
    private String username;
    @Value("${oracle.oci.administration.tenancy}")
    private String tenancy;

    @Bean
    public ProducerFactory<String, String> producerFactory() {
        Map<String, Object> properties = new HashMap<>();
        properties.put(BOOTSTRAP_SERVERS, bootstrapServers);
        properties.put(SASL_JAAS_CONFIG, saslJaasConfig);
        properties.put(MAX_REQUEST_SIZE, maxRequestSize);
        properties.put(RETRIES, retries);
        properties.put(SECURITY_PROTOCOL, protocol);
        properties.put(SASL_MECHANISM, mechanism);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        return new DefaultKafkaProducerFactory<>(properties);
    }

    @Bean
    public ConsumerFactory<String, String> consumerFactory() {
        Map<String, Object> properties = new HashMap<>();
        properties.put(BOOTSTRAP_SERVERS, bootstrapServers);
        properties.put(SASL_JAAS_CONFIG, saslJaasConfig);
        properties.put(GROUP_ID, groupId);
        properties.put(ENABLE_AUTO_COMMIT, enableAutoCommit);
        properties.put(SESSION_TIMEOUT_MS, sessionTimeoutMs);
        properties.put(AUTO_OFFSET_RESET, autoOffsetReset);
        properties.put(SECURITY_PROTOCOL, protocol);
        properties.put(SASL_MECHANISM, mechanism);
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        return new DefaultKafkaConsumerFactory<>(properties);
    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}
