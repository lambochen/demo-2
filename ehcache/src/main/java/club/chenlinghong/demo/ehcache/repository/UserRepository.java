package club.chenlinghong.demo.ehcache.repository;

import club.chenlinghong.demo.ehcache.entity.User;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * @Description 用户仓库类
 * @Author chenlinghong
 * @Date 2019/9/20 0:18
 */
@Slf4j
@Component
public class UserRepository {

    /**
     * 内存数据库
     */
    private Map<Integer, User> userMap = Maps.newConcurrentMap();

    /**
     * 初始化
     */
    @PostConstruct
    private void init() {
        userMap.put(1, new User(1, "Alice"));
        userMap.put(2, new User(2, "Bob"));
    }

    /**
     * 此处的 cacheNames 需要和 ehcache 配置文件的配置项一致
     */
    @Cacheable(cacheNames = "user", key = "#id")
    public User getById(Integer id) {
        log.info("UserRepository#getById: id={}", id);
        return userMap.get(id);
    }

}
