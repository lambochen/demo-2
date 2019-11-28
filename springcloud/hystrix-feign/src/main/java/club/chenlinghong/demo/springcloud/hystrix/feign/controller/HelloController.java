package club.chenlinghong.demo.springcloud.hystrix.feign.controller;

import club.chenlinghong.demo.springcloud.hystrix.feign.client.SchedualServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author linghongchen
 * @Date 2019/11/28 9:04 下午
 * @Description hello world
 **/
@RestController
public class HelloController {

    @Autowired
    SchedualServiceHi schedualServiceHi;

    @GetMapping("hi")
    public String sagHi(@RequestParam String name) {
        return schedualServiceHi.sayHiFromClientOne(name);
    }

}
