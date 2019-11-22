package club.chenlinghong.demo.mybatisplus.generator.codegenerator.service.impl;

import club.chenlinghong.demo.mybatisplus.generator.codegenerator.service.IUserService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(
        SpringRunner.class
)
@SpringBootTest
public class UserServiceImplTest {
    @Autowired
    private IUserService userService;

    @Test
    public void selectUserPage() {
        System.out.println(userService.selectUserPage(new Page<>(), 1));

    }

}
