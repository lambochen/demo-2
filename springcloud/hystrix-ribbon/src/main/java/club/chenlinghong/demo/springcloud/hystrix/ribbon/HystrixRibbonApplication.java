package club.chenlinghong.demo.springcloud.hystrix.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableHystrix
@EnableEurekaClient
public class HystrixRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixRibbonApplication.class, args);
    }

}
