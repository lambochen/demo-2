package club.chenlinghong.demo.aop.annotation;

import org.springframework.stereotype.Service;

/**
 * @Description 注解使用类
 * @Author linghongchen
 * @Date 2019-08-02 10:44
 **/
@Service
public class AnnotationServiceDemo {

    @AnnotationTest("v2")
    public String arroud(String name){
        System.out.println("AnnotationServiceDemo#add");
        return "AnnotationServiceDemo#add";
    }

    // @AnnotationTest("v2")
    public String add(){
        System.out.println("AnnotationServiceDemo#add");
        return "AnnotationServiceDemo#add";
    }


}
