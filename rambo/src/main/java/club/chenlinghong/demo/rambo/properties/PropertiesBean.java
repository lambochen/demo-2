package club.chenlinghong.demo.rambo.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Description Bean 方式获取
 * @Author Lambo Chen
 * @Date 2019/10/20 10:56
 */
@Component
@ConfigurationProperties
@PropertySource(value = {"classpath:test-c.properties"}, encoding = "UTF-8")
@Data
public class PropertiesBean {

    /**
     * ID 对应配置属性：id
     */
    private int id;

    /**
     * name 对应配置属性：name
     */
    private String name;
}
