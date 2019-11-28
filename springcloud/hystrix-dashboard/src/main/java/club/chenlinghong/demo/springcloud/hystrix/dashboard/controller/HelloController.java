package club.chenlinghong.demo.springcloud.hystrix.dashboard.controller;

import club.chenlinghong.demo.springcloud.hystrix.dashboard.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author linghongchen
 * @Date 2019/11/28 8:48 下午
 * @Description TODO
 **/
@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping(value = "/hi")
    public String hi(@RequestParam String name) {
        return helloService.hiService(name);
    }

}
