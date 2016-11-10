package cn.huangchaosuper.kafka.metric;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by chaohuang on 10/11/2016.
 */
public class KafkaHelper {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);
    private KafkaConsumer<String, String> kafkaConsumer = null;

    public KafkaHelper(KafkaConsumer<String, String> kafkaConsumer) {
        this.kafkaConsumer = kafkaConsumer;
    }

    public void run() {
        this.kafkaConsumer.listTopics().forEach((k, v) -> {
            logger.info("topic={},value={}", k);
            v.forEach((p) -> {
                logger.info(p.toString());
            });
        });
    }

}
