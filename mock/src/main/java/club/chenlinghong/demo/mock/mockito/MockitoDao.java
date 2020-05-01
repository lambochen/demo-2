package club.chenlinghong.demo.mock.mockito;

import org.springframework.stereotype.Component;

/**
 * @Author lambo.chen.2306@gmail.com
 * @Date 2020/5/1 18:57
 * @Description mockito dao
 **/
@Component
public class MockitoDao {

    /**
     * 获取数据
     * @return
     */
    public String getData() {
        // 具体实现不重要，反正都会 mock
        return "data";
    }

}
