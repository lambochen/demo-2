package club.chenlinghong.demo.springsecurity.jwt.service;

import club.chenlinghong.demo.springsecurity.jwt.dao.UserDao;
import club.chenlinghong.demo.springsecurity.jwt.entity.JwtUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @Author lambo.chen.2306@gmail.com
 * @Date 2019/12/16 8:23 下午
 * @Description SpringSecurity UserDetailsService 实现类
 **/
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return new JwtUser(userDao.getByUsername(s));
    }
}
