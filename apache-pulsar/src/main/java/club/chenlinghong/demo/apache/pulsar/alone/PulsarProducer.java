package club.chenlinghong.demo.apache.pulsar.alone;

import org.apache.pulsar.client.api.Producer;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;
import org.apache.pulsar.client.api.Schema;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author lambo.chen.2306@gmail.com
 * @Date 2019/12/26 1:30
 * @Description pulsar producer
 **/
public class PulsarProducer {

    private static final String MESSAGE_TEMPLATE = "pulsar-message-%s";

    public static void main(String [] args) throws PulsarClientException, InterruptedException {
        Executors.newFixedThreadPool(1).execute(() -> {
            try {
                PulsarClient client = PulsarClientBuilder.getInstance();
                Producer<String> producer = client.newProducer(Schema.STRING)
                        .topic(PulsarClientBuilder.Topic.DEMO.getTopic())
                        .batchingMaxPublishDelay(10, TimeUnit.MICROSECONDS)
                        .sendTimeout(10, TimeUnit.SECONDS)
                        .blockIfQueueFull(true)
                        .create();
                int index = 0;
                while (true) {
                    String message = String.format(MESSAGE_TEMPLATE, ++index);
                    System.out.println("send message: " + message);
                    producer.send(message);
                    Thread.sleep(5000);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        });
    }
}
