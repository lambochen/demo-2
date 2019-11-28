package club.chenlinghong.demo.springcloud.hystrix.dashboard.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @Author linghongchen
 * @Date 2019/11/28 8:44 下午
 * @Description ribbon 配置
 **/
@Component
public class RibbonConfig {

    /**
     * 注入 restTemplate， 采用 ribbon 做客户端负载均衡
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
