package club.chenlinghong.demo.rambo.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @Description Environment 方式读取配置文件
 * @Author Lambo Chen
 * @Date 2019/10/20 10:43
 */
@Component
@PropertySource(value = {"classpath:test-a.properties"}, encoding = "UTF-8")
public class EnvironmentDemo {

    @Autowired
    private Environment environment;

    public String getEnvironment() {
        return environment.getProperty("test.environment");
    }
}
