package club.chenlinghong.demo.apache.pulsar;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;

/**
 * @Author lambo.chen.2306@gmail.com
 * @Date 2019/12/26 1:23
 * @Description Pulsar 初始化及配置
 **/
public class PulsarClientBuilder {

    private static PulsarClient client;

    /**
     * pulsar 服务器连接地址
     */
    private static final String PULSAR_SERVER_URL = "pulsar://chenlinghong.club:6650";

    private PulsarClientBuilder(){

    }

    public static PulsarClient getInstance(){
        if (client == null) {
            try {
                client = PulsarClient.builder().serviceUrl(PULSAR_SERVER_URL).build();
            } catch (PulsarClientException e) {
                e.printStackTrace();
            }
        }
        return client;
    }

    @AllArgsConstructor
    @Getter
    public enum Topic {
        /**
         * demo topic (Pulsar 会自动创建)
         */
        DEMO("demo-topic"),

        ;

        private String topic;
    }

    @AllArgsConstructor
    @Getter
    public enum Subscription {

        /**
         * consumer
         */
        DEMO("demo-subscription"),
        ;

        private String subscription;
    }


}
