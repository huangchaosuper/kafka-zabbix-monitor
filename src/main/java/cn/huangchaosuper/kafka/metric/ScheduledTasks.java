package cn.huangchaosuper.kafka.metric;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
/**
 * Created by chaohuang on 10/11/2016.
 */
@Component
public class ScheduledTasks {
    @Autowired()
    @Qualifier("kafkaConsumer")
    KafkaConsumer kafkaConsumer;

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        log.info("The time is now {}", dateFormat.format(new Date()));
        KafkaHelper kafkaHelper = new KafkaHelper(kafkaConsumer);
        kafkaHelper.run();
    }
}
