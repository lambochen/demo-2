package club.chenlinghong.demo.mybatisplus.generator.codegenerator.service.impl;

import club.chenlinghong.demo.mybatisplus.generator.codegenerator.entity.User;
import club.chenlinghong.demo.mybatisplus.generator.codegenerator.mapper.UserMapper;
import club.chenlinghong.demo.mybatisplus.generator.codegenerator.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lambo
 * @since 2019-11-22
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
