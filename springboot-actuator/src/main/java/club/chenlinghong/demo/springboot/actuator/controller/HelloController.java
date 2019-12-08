package club.chenlinghong.demo.springboot.actuator.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Lambo Chen
 * @Date 2019/12/8 4:21 下午
 * @Description 测试
 **/
@RestController
@Slf4j
public class HelloController {

    @GetMapping("/hi")
    public String hello(){
        String result = "hi, " + System.currentTimeMillis();
        log.info(result);
        return result;
    }

}
