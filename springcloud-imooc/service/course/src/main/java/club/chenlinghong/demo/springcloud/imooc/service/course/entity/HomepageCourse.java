package club.chenlinghong.demo.springcloud.imooc.service.course.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Author lambo.chen.2306@gmail.com
 * @Date 2020/3/31 21:32
 * @Description TODO
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "homepage_course")
public class HomepageCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic
    @Column(name = "create_time", nullable = false)
    @CreatedDate
    private Date createTime;

    @Basic
    @Column(name = "update_time", nullable = false)
    @LastModifiedDate
    private Date updateTime;

    @Basic
    @Column(name = "course_name", nullable = false)
    private String courseName;

    /**
     * TODO 省略其他字段
     */
}
