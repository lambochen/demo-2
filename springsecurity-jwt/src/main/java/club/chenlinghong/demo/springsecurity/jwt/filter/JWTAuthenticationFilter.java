package club.chenlinghong.demo.springsecurity.jwt.filter;

import club.chenlinghong.demo.springsecurity.jwt.entity.JwtUser;
import club.chenlinghong.demo.springsecurity.jwt.model.LoginUser;
import club.chenlinghong.demo.springsecurity.jwt.util.JwtTokenUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

/**
 * @Author lambo.chen.2306@gmail.com
 * @Date 2019/12/16 8:33 下午
 * @Description 验证
 **/
@Slf4j
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    private ThreadLocal<Integer> rememberMe = new ThreadLocal<>();

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        // 登录路径
        super.setFilterProcessesUrl("/auth/login");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        // 从输入流中获取到登录信息
        try {
            LoginUser loginUser = new ObjectMapper().readValue(request.getInputStream(), LoginUser.class);
            rememberMe.set(loginUser.getRememberMe());
            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginUser.getUsername(),
                            loginUser.getPassword(), Lists.newArrayList())
            );
        } catch (IOException e) {
            log.error("JWTAuthenticationFilter#attemptAuthentication: {}", e);
            return null;
        }
    }

    /**
     * 成功验证后调用的方法， 此处：生成 token 返回
     *
     * @param request
     * @param response
     * @param chain
     * @param authResult
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                            FilterChain chain, Authentication authResult) throws IOException, ServletException {
        JwtUser jwtUser = (JwtUser) authResult.getPrincipal();

        boolean isRemember = rememberMe.get() != null && rememberMe.get() == 1;
        String role = "";

        // jwtuser 中存储了权限信息，直接获取
        Collection<? extends GrantedAuthority> authorities = jwtUser.getAuthorities();
        for (GrantedAuthority authority : authorities) {
            role = authority.getAuthority();
        }

        log.info("jwtUser: {}", jwtUser);
        String token = JwtTokenUtil.createToken(jwtUser.getUsername(), role, isRemember);
        /**
         * 返回创建成功的 token
         * JWT规定，最后请求的格式： Bearer token
         */
        response.setHeader("token", JwtTokenUtil.TOKEN_PREFIX + token);
//        super.successfulAuthentication(request, response, chain, authResult);
    }

    /**
     * 验证失败调用方法
     *
     * @param request
     * @param response
     * @param failed
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                              AuthenticationException failed) throws IOException,
            ServletException {
        response.getWriter().write("authentication failed, reason: " + failed.getMessage());
//        super.unsuccessfulAuthentication(request, response, failed);
    }
}
