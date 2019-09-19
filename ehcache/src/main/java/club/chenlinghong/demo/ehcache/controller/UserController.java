package club.chenlinghong.demo.ehcache.controller;

import club.chenlinghong.demo.ehcache.entity.User;
import club.chenlinghong.demo.ehcache.service.UserService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;

/**
 * @Description 用户controller
 * @Author chenlinghong
 * @Date 2019/9/20 0:28
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 根据ID获取用户信息
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public User getById(@PathVariable(value = "id")
                        @NonNull @Min(value = 1, message = "id 为非负数") Integer id) {
        return userService.getById(id);
    }

}
