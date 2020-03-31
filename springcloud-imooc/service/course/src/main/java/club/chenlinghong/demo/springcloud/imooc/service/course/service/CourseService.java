package club.chenlinghong.demo.springcloud.imooc.service.course.service;

import club.chenlinghong.demo.springcloud.imooc.service.common.CourseInfo;
import club.chenlinghong.demo.springcloud.imooc.service.common.CourseInfosRequest;
import club.chenlinghong.demo.springcloud.imooc.service.course.entity.HomepageCourse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author lambo.chen.2306@gmail.com
 * @Date 2020/3/31 21:44
 * @Description TODO
 **/
public interface CourseService {

    /**
     * 通过 id 获取课程信息
     * @param id
     * @return
     */
    CourseInfo getCourseInfo(long id);

    /**
     * 通过 ids 获取课程信息
     * @param request
     * @return
     */
    List<CourseInfo> getCourseInfos(CourseInfosRequest request);

}

@Slf4j
@Service
class CourseServiceImpl implements CourseService {

//    @Autowired
//    private HomepageCourseDao dao;

    @Override
    public CourseInfo getCourseInfo(long id) {
        return null;
    }

    @Override
    public List<CourseInfo> getCourseInfos(CourseInfosRequest request) {
        return null;
    }

    private CourseInfo build(HomepageCourse course) {
        return CourseInfo.builder()
                .id(course.getId())
                .courseName(course.getCourseName())
                // TODO 其他字段
                .build();
    }
}
