package club.chenlinghong.demo.rambo.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author Lambo Chen
 * @Date 2019/10/20 10:27
 */
@Data
@PropertySource(value = {"classpath:test-a.properties", "classpath:test-b.properties"}, encoding = "UTF-8")
@Component
public class PropertiesDemo {

    /**
     * test-a.properties 文件中 test.a 属性
     */
    @Value("${test.a}")
    private String aValue;

    /**
     * test-b.properties 文件中 test.b 属性
     */
    @Value("${test.b}")
    private String bValue;

}
