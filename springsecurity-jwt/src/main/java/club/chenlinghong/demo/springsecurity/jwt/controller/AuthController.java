package club.chenlinghong.demo.springsecurity.jwt.controller;

import club.chenlinghong.demo.springsecurity.jwt.dao.UserDao;
import club.chenlinghong.demo.springsecurity.jwt.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author lambo.chen.2306@gmail.com
 * @Date 2019/12/16 9:09 下午
 * @Description 校验
 **/
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * 注册用户
     *
     * @param registerUser
     * @return
     */
    @PostMapping("/register")
    public String registerUser(@RequestBody Map<String, String> registerUser) {
        User user = new User();
        user.setUsername(registerUser.get("username"));
        // 加密密码
        user.setPassword(bCryptPasswordEncoder.encode(registerUser.get("password")));
        user.setRole("ROLE_USER");
        User save = userDao.save(user);
        return save.toString();
    }
}
