package club.chenlinghong.demo.springcloud.demo.fymod.fymod.eureka.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Author Lambo Chen
 * @Date 2019/12/8 5:35 下午
 * @Description Spring Security 配置
 **/
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // spring cloud security 默认启用了csrf，需要关闭
        http.csrf().disable().authorizeRequests().anyRequest().authenticated().and().httpBasic();
//        super.configure(http);
    }

}
