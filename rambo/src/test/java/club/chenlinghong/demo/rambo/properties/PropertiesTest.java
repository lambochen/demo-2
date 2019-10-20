package club.chenlinghong.demo.rambo.properties;
import	java.security.PublicKey;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description properties 配置文件测试
 * @Author Lambo Chen
 * @Date 2019/10/20 10:29
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PropertiesTest {

    @Autowired
    private PropertiesDemo propertiesDemo;

    @Test
    public void test() {
        System.out.println("aValue:" + propertiesDemo.getAValue());
        System.out.println("bValue:" + propertiesDemo.getBValue());
    }
}
