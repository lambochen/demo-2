package club.chenlinghong.demo.springcloud.config.distributed.config.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author linghongchen
 * @Date 2019/11/28 11:07 下午
 * @Description TODO
 **/
@RestController
public class HelloController {

    @Value("${foo}")
    String foo;

    @Value("${config-test}")
    String configTest;

    @GetMapping(value = "/hi")
    public String hi(){
        return foo + configTest;
    }

}
