package club.chenlinghong.demo.mock.mockaop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.aop.framework.Advised;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MockAopTest {

    @InjectMocks
    @Autowired
    private MockAopDemo mockAopDemo;

    @Test
    public void mockAop() {
        String item = mockAopDemo.mockAop();
        System.out.println("test:" + item);
    }

    /**
     * 在Mock时，AOP失效：
     * https://stackoverflow.com/questions/16902389/spring-aop-aspect-not-working-using-mockito
     */

    public static final Object unwrapProxy(Object bean) throws Exception {
        /*
         * If the given object is a proxy, set the return value as the object
         * being proxied, otherwise return the given object.
         */
        if (AopUtils.isAopProxy(bean) && bean instanceof Advised) {
            Advised advised = (Advised) bean;
            bean = advised.getTargetSource().getTarget();
        }
        return bean;
    }
}