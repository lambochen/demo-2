package club.chenlinghong.demo.rambo.properties;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description TODO
 * @Author Lambo Chen
 * @Date 2019/10/20 11:12
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class YmlTest {

    @Autowired
    private YmlDemo ymlDemo;

    @Test
    public void test() {
        System.out.println(ymlDemo.getId());
        System.out.println(ymlDemo.getName());
    }

}
