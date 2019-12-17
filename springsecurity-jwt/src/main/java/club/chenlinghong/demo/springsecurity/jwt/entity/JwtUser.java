package club.chenlinghong.demo.springsecurity.jwt.entity;

import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

/**
 * @Author lambo.chen.2306@gmail.com
 * @Date 2019/12/16 8:25 下午
 * @Description JWT 用户信息 （需要实现 UserDetails）
 **/
@NoArgsConstructor
@ToString
public class JwtUser implements UserDetails {

    private Integer id;
    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public JwtUser(User user) {
        id = user.getId();
        username = user.getUsername();
        password = user.getPassword();
        // 只存储角色名字
        authorities = Collections.singleton(new SimpleGrantedAuthority(user.getRole()));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        /**
         * 账号是否未过期，默认 false
         */
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // 账号是否未锁定
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // 账号凭证是否未过期
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
