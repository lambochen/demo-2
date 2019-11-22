package club.chenlinghong.demo.mybatisplus.entity;

import lombok.Data;

/**
 * @Author linghongchen
 * @Date 2019/11/22 7:52 下午
 * @Description 用户实体
 **/
@Data
public class User {

    private Long id;
    private String name;
    private Integer age;
    private String email;

}
