package club.chenlinghong.demo.springcloud.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author linghongchen
 * @Date 2019/11/28 8:59 下午
 * @Description Feign 客户端 —— "service-hi"
 **/
@FeignClient(value = "service-hi")
public interface SchedualServiceHi {

    @GetMapping("hi")
    String sayHiFromClientOne(@RequestParam(value = "name") String name);

}
