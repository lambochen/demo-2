package club.chenlinghong.demo.springcloud.imooc.service.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Author lambo.chen.2306@gmail.com
 * @Date 2020/3/30 0:50
 * @Description 用户基本信息
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class UserInfo implements Serializable {

    private static final long serialVersionUID = -2688397738872701243L;

    private Long id;
    private String username;
    private String email;

    /**
     * 无效的用户信息对象
     * @return
     */
    public static UserInfo invalid() {
        return new UserInfo(-1L, "", "");
    }
}
