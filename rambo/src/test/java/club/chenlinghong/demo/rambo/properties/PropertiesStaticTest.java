package club.chenlinghong.demo.rambo.properties;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description TODO
 * @Author Lambo Chen
 * @Date 2019/10/20 11:26
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PropertiesStaticTest {

    @Test
    public void test() {
        System.out.println("aValue:" + PropertiesStaticDemo.aValue);
        System.out.println("bValue:" + PropertiesStaticDemo.bValue);
    }

}
