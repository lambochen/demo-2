package club.chenlinghong.demo.springcloud.eureka.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author linghongchen
 * @Date 2019/11/28 8:30 下午
 * @Description hello world
 **/
@RestController
public class HelloController {

    @Value("${server.port}")
    String port;

    @RequestMapping("/hi")
    public String home(@RequestParam String name) {
        return "hi " + name + ",i am from port:" + port;
    }


}
