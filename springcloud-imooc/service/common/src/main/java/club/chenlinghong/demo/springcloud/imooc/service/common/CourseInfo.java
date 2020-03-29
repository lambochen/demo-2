package club.chenlinghong.demo.springcloud.imooc.service.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Author lambo.chen.2306@gmail.com
 * @Date 2020/3/30 0:52
 * @Description TODO
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class CourseInfo implements Serializable {

    private static final long serialVersionUID = -6475361300940320940L;

    private Long id;
    private String courseName;
    private String courseType;
    private String courseIcon;
    private String courseIntro;

    public static CourseInfo invalid() {
        return new CourseInfo(-1L, "", "", "", "" );
    }
}
