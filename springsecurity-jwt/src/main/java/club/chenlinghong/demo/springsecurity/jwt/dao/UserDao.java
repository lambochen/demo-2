package club.chenlinghong.demo.springsecurity.jwt.dao;

import club.chenlinghong.demo.springsecurity.jwt.entity.User;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * @Author lambo.chen.2306@gmail.com
 * @Date 2019/12/16 8:19 下午
 * @Description 用户 DAO
 **/
@Component
public class UserDao {

    Map<String, User> data;

    @PostConstruct
    public void init() {
        data = Maps.newConcurrentMap();
        User alice = new User().setId(1).setUsername("alice").setPassword("$2a$10$BjgAIY8XdDvTE2CsVlmP.OCaSNT5VvGPtoXLzQydH/AzQKUQE12UO").setRole("ROLE_USER");
        data.put(alice.getUsername(), alice);
    }

    /**
     * 根据 username 查询
     *
     * @param username
     * @return
     */
    public User getByUsername(String username) {
        return data.get(username);
    }


    public User save(User user) {
        user.setId((int) (Math.random() * 1000L));
        data.put(user.getUsername(), user);
        return user;
    }
}
