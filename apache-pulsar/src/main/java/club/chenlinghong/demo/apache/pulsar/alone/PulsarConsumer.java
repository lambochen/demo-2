package club.chenlinghong.demo.apache.pulsar.alone;

import org.apache.pulsar.client.api.Consumer;
import org.apache.pulsar.client.api.Message;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;
import org.apache.pulsar.client.api.Schema;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;

/**
 * @Author lambo.chen.2306@gmail.com
 * @Date 2019/12/26 1:36
 * @Description pulsar consumer
 **/
@Component
public class PulsarConsumer {


//    static {
//        try {
//            receive();
//        } catch (PulsarClientException e) {
//            e.printStackTrace();
//        }
//    }

    @Bean
    public static void receive() throws PulsarClientException {
        Executors.newFixedThreadPool(1).execute(() -> {
            try {
                PulsarClient client = PulsarClientBuilder.getInstance();
                Consumer consumer = client.newConsumer(Schema.STRING)
                        .topic(PulsarClientBuilder.Topic.DEMO.getTopic())
                        .subscriptionName(PulsarClientBuilder.Subscription.DEMO.getSubscription())
                        .subscribe();
                while (true) {
                    Message message = consumer.receive();
                    System.out.println("receive message: " + message.getValue());
                    consumer.acknowledgeAsync(message);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        });
    }

}
