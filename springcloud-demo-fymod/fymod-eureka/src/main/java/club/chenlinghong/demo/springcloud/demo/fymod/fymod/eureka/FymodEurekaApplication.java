package club.chenlinghong.demo.springcloud.demo.fymod.fymod.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class FymodEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(FymodEurekaApplication.class, args);
    }

}
