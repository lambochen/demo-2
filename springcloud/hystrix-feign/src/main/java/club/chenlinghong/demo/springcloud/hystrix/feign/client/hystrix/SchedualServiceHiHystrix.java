package club.chenlinghong.demo.springcloud.hystrix.feign.client.hystrix;

import club.chenlinghong.demo.springcloud.hystrix.feign.client.SchedualServiceHi;
import org.springframework.stereotype.Component;

/**
 * @Author linghongchen
 * @Date 2019/11/28 9:43 下午
 * @Description Hystrix 补偿逻辑
 **/
@Component
public class SchedualServiceHiHystrix implements SchedualServiceHi {

    @Override
    public String sayHiFromClientOne(String name) {
        return "hystrix.feign: error, " + name;
    }
}
