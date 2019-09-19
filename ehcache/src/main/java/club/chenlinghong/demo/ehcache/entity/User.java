package club.chenlinghong.demo.ehcache.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Description 用户实体
 * @Author chenlinghong
 * @Date 2019/9/19 23:58
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * 建造者模式 链式调用
 */
@Accessors(chain = true)
public class User implements Serializable {

    private static final long serialVersionUID = -8451701378160929387L;

    /**
     * 用户ID
     */
    private Integer id;

    /**
     * 用户name
     */
    private String name;
}
