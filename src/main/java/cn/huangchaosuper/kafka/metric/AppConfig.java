package cn.huangchaosuper.kafka.metric;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Properties;

/**
 * Created by chaohuang on 10/11/2016.
 */
@PropertySource("classpath:application.properties")
@Configuration
public class AppConfig {
    private static final Logger logger = LoggerFactory.getLogger(AppConfig.class);

    @Bean
    public KafkaConsumer<String,String> KafkaConsumer(
            @Value("${bootstrap.servers}") String bootstrapServers,
            @Value("${group.id}") String groupId,
            @Value("${enable.auto.commit}") String enableAutoCommit,
            @Value("${session.timeout.ms}") String sessionTimeoutMs,
            @Value("${key.deserializer}") String keyDeserializer,
            @Value("${value.deserializer}") String valueDeserializer
    ){
        Properties properties = new Properties();
        properties.put("bootstrap.servers", bootstrapServers);
        properties.put("group.id", groupId);
        properties.put("enable.auto.commit", enableAutoCommit);
        properties.put("session.timeout.ms", sessionTimeoutMs);
        properties.put("key.deserializer", keyDeserializer);
        properties.put("value.deserializer", valueDeserializer);
        return new KafkaConsumer<String, String>(properties);
    }
}
