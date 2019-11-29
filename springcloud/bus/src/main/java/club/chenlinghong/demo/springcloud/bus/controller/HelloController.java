package club.chenlinghong.demo.springcloud.bus.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author linghongchen
 * @Date 2019/11/28 11:07 下午
 * @Description TODO
 **/
// 配置自动更新
@RefreshScope
@RestController
public class HelloController {

    @Value("${foo}")
    String foo;

    @GetMapping(value = "/hi")
    public String hi(){
        return foo;
    }

}
