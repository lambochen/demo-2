package club.chenlinghong.demo.rambo.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Description 读取配置属性赋值静态变量
 * @Author Lambo Chen
 * @Date 2019/10/20 11:25
 */
@Data
@PropertySource(value = {"classpath:test-a.properties", "classpath:test-b.properties"}, encoding = "UTF-8")
@Component
public class PropertiesStaticDemo {

    /**
     * test-a.properties 文件中 test.a 属性
     */
    public static String aValue;

    /**
     * test-b.properties 文件中 test.b 属性
     */
    public static String bValue;

    /**
     * 获取配置文件项 test.a 给参数 aValue 赋值，然后通过方法体给 静态属性 PropertiesStaticDemo.aValue 赋值
     */
    @Value("${test.a}")
    public void setAValue(String aValue) {
        PropertiesStaticDemo.aValue = aValue;
    }

    @Value("${test.b}")
    public void setBValue(String bValue) {
        PropertiesStaticDemo.bValue = bValue;
    }
}
