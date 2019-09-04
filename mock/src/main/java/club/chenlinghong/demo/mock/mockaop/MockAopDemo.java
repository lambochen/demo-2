package club.chenlinghong.demo.mock.mockaop;

import club.chenlinghong.demo.mock.mockaop.aop.MockDemoLog;
import org.springframework.stereotype.Component;

/**
 * @Description Mock aop结合使用
 * @Author linghongchen
 * @Date 2019-08-26 12:15
 **/
@Component
public class MockAopDemo {


    @MockDemoLog(name = "mockAop")
    public String mockAop(){
        String item = "qweergdfdf";
        // TODO
        return item;
    }


}
