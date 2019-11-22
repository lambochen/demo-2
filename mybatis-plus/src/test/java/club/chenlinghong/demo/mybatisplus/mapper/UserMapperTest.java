package club.chenlinghong.demo.mybatisplus.mapper;

import club.chenlinghong.demo.mybatisplus.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void selectList(){
        List<User> userList = userMapper.selectList(null);
        assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }


}
