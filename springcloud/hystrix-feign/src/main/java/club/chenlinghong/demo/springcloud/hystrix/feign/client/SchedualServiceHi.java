package club.chenlinghong.demo.springcloud.hystrix.feign.client;

import club.chenlinghong.demo.springcloud.hystrix.feign.client.hystrix.SchedualServiceHiHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author linghongchen
 * @Date 2019/11/28 8:59 下午
 * @Description Feign 客户端 —— "service-hi"
 **/
@FeignClient(value = "service-hi", fallback = SchedualServiceHiHystrix.class)
public interface SchedualServiceHi {

    @GetMapping("hi")
    String sayHiFromClientOne(@RequestParam(value = "name") String name);

}
