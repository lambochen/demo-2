package club.chenlinghong.demo.ehcache.service.impl;

import club.chenlinghong.demo.ehcache.entity.User;
import club.chenlinghong.demo.ehcache.repository.UserRepository;
import club.chenlinghong.demo.ehcache.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @Description 用户service 实现类
 * @Author chenlinghong
 * @Date 2019/9/20 0:00
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getById(Integer id) {
        log.info("UserService#getById: id={}", id);
        return userRepository.getById(id);
    }
}
