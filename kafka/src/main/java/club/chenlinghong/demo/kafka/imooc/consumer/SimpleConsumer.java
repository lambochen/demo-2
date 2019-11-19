package club.chenlinghong.demo.kafka.imooc.consumer;

import club.chenlinghong.demo.kafka.imooc.common.MessageEntity;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @Description 消费者
 * @Author Lambo Chen
 * @Date 2019/11/12 23:01
 */
@Slf4j
@Component
public class SimpleConsumer {

    private final Gson gson = new Gson();

    @KafkaListener(topics = "${kafka.topic.default}", containerFactory = "kafkaListenerContainerFactory")
    public void consumer(MessageEntity message){
        log.info(gson.toJson(message));
    }
}
