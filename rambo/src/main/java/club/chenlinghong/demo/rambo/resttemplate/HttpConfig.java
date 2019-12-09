package club.chenlinghong.demo.rambo.resttemplate;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @Author Lambo Chen
 * @Date 2019/12/9 9:54 下午
 * @Description TODO
 **
 */
@Component
public class HttpConfig {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }


}
