package club.chenlinghong.demo.rambo.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Description yml 方式获取示例
 * @Author Lambo Chen
 * @Date 2019/10/20 11:11
 */
@Component
@ConfigurationProperties(prefix = "bob")
@Data
public class YmlDemo {

    /**
     * 对应 配置文件 bob.id
     */
    private int id;

    /**
     * 对应配置文件 bob.name
     */
    private String name;

}
