package club.chenlinghong.demo.springcloud.imooc.service.course.controller;

import club.chenlinghong.demo.springcloud.imooc.service.common.CourseInfo;
import club.chenlinghong.demo.springcloud.imooc.service.common.CourseInfosRequest;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author lambo.chen.2306@gmail.com
 * @Date 2020/3/31 21:51
 * @Description TODO
 **/
@Slf4j
@RestController
public class HomepageCourseController {

    public CourseInfo getCourseInfo(Long id) {
        log.info("HomepageCourseController -> getCourseInfo {}", id);
        return CourseInfo.builder().courseName("getCourseInfo -> " + id).build();
    }

    public List<CourseInfo> getCourseInfos(@RequestBody CourseInfosRequest request) {
        log.info("HomepageCourseController -> getCourseInfos {}", request);
        return Lists.newArrayList();
    }

}
