package club.chenlinghong.demo.ehcache.service;

import club.chenlinghong.demo.ehcache.entity.User;

/**
 * @Description 用户service
 * @Author chenlinghong
 * @Date 2019/9/19 23:59
 */
public interface UserService {

    /**
     * 根据ID获取用户数据
     *
     * @param id
     * @return
     */
    User getById(Integer id);

}
