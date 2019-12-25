package club.chenlinghong.demo.apache.pulsar;

import org.apache.pulsar.client.api.Consumer;
import org.apache.pulsar.client.api.Message;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;
import org.apache.pulsar.client.api.Schema;

import java.util.concurrent.Executors;

/**
 * @Author lambo.chen.2306@gmail.com
 * @Date 2019/12/26 1:36
 * @Description pulsar consumer
 **/
public class PulsarConsumer {

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
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        });
    }

}
