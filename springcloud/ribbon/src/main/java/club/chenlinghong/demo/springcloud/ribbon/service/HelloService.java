package club.chenlinghong.demo.springcloud.ribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Author linghongchen
 * @Date 2019/11/28 8:47 下午
 * @Description TODO
 **/
@Service
public class HelloService {

    @Autowired
    private RestTemplate restTemplate;

    private static final String urlPrefix = "http://SERVICE-HI/hi?name=";

    public String hiService(String name) {
        return restTemplate.getForObject(urlPrefix + name, String.class);
    }
}
