package club.chenlinghong.demo.aop.annotation;

import club.chenlinghong.demo.aop.AopApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AnnotationServiceDemoTest extends AopApplicationTests {

    @Autowired
    private AnnotationServiceDemo annotationServiceDemo;

    @Test
    public void add() {
        annotationServiceDemo.add();
    }

    @Test
    public void around(){
        System.out.println(annotationServiceDemo.arroud("test"));
    }
}