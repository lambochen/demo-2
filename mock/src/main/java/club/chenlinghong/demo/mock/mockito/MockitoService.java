package club.chenlinghong.demo.mock.mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author lambo.chen.2306@gmail.com
 * @Date 2020/5/1 18:57
 * @Description mockito service
 **/
@Service
public class MockitoService {

    @Autowired
    private MockitoDao mockitoDao;

    public String getData() {
        String data = mockitoDao.getData();
        return "service:" + data;
    }
}
