package club.chenlinghong.demo.rambo.properties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description bean方式获取
 * @Author Lambo Chen
 * @Date 2019/10/20 10:58
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PropertiesBeanTest {

    @Autowired
    private PropertiesBean propertiesBean;

    @Test
    public void test() {
        System.out.println(propertiesBean.getId());
        System.out.println(propertiesBean.getName());
    }

}
