package club.chenlinghong.demo.springsecurity.jwt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Author lambo.chen.2306@gmail.com
 * @Date 2019/12/16 7:57 下午
 * @Description 用户
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class User implements Serializable {

    private static final long serialVersionUID = -4214377440065864569L;
    
    private Integer id;
    private String username;
    private String password;
    /**
     * 权限 角色
     */
    private String role;

}
