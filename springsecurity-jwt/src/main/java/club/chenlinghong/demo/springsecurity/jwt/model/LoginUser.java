package club.chenlinghong.demo.springsecurity.jwt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @Author lambo.chen.2306@gmail.com
 * @Date 2019/12/16 8:35 下午
 * @Description 登录信息
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class LoginUser {

    private String username;
    private String password;
    private Integer rememberMe;

}
