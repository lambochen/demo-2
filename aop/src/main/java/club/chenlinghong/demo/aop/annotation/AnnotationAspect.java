package club.chenlinghong.demo.aop.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Description aspect实现类
 * @Author linghongchen
 * @Date 2019-08-02 10:48
 **/
@Aspect
@Component
public class AnnotationAspect {

    @Pointcut("@annotation(club.chenlinghong.demo.aop.annotation.AnnotationTest)")
    public void annotationPointCut() {

    }

    // @Before("annotationPointCut()")
    // public void before(JoinPoint joinPoint) {
    //     MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
    //     Method method = methodSignature.getMethod();
    //     AnnotationTest annotation = method.getAnnotation(AnnotationTest.class);
    //     System.out.println("注解式拦截:" + annotation.value());
    //
    // }

    @Around("annotationPointCut()")
    public String around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = methodSignature.getMethod();
        AnnotationTest annotation = method.getAnnotation(AnnotationTest.class);
        System.out.println("注解式拦截:" + annotation.value());
       for (int i = 0; i < proceedingJoinPoint.getArgs().length ; i++){
           System.out.println(proceedingJoinPoint.getArgs()[i]);
       }


        if ("v2".equalsIgnoreCase(annotation.value())){
            System.out.println("执行了 around v2");
            return "执行了 around v2";
        } else {
            proceedingJoinPoint.proceed();
            System.out.println("执行around 尾部");
            return "执行around 尾部";
        }
    }


}
