package club.chenlinghong.demo.mybatisplus.generator.codegenerator.service;

import club.chenlinghong.demo.mybatisplus.generator.codegenerator.entity.User;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lambo
 * @since 2019-11-22
 */
public interface IUserService extends IService<User> {

    /**
     * 分页查询
     * @param page
     * @param state
     * @return
     */
    IPage<User> selectUserPage(Page<User> page, Integer state);
}
