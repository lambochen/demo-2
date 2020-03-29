package club.chenlinghong.demo.springcloud.imooc.service.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @Author lambo.chen.2306@gmail.com
 * @Date 2020/3/30 0:54
 * @Description 课程信息请求对象
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class CourseInfosRequest implements Serializable {

    private static final long serialVersionUID = -315141759551053963L;

    private List<Long> ids;
}
