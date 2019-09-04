package club.chenlinghong.demo.mock.mockaop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Description 日志注解切面
 * @Author linghongchen
 * @Date 2019-08-26 11:44
 **/
@Aspect
@Component
public class MockDemoLogAspect {

    @Pointcut(value = "@annotation(club.chenlinghong.demo.mock.aop.MockDemoLog)")
    public void pointcut() {

    }

    @Before(value = "pointcut() && @annotation(mockDemoLog)")
    public void beforeAspect(JoinPoint joinPoint, MockDemoLog mockDemoLog) {
        /**
         * 当采用Mockito来mock数据的时候，发现不进此增强
         * 可能原因：
         * 1、mock数据时忽略AOP
         * 2、mock数据时覆盖掉了AOP
         */
        System.out.println("MockDemoLogAspect#beforeAspect: " + mockDemoLog.name());
    }


}
