package club.chenlinghong.demo.springsecurity.jwt.filter;

import club.chenlinghong.demo.springsecurity.jwt.exception.TokenIsExpiredException;
import club.chenlinghong.demo.springsecurity.jwt.util.JwtTokenUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

/**
 * @Author lambo.chen.2306@gmail.com
 * @Date 2019/12/16 8:45 下午
 * @Description 鉴权
 **/
public class JWTAuthorizationFilter extends BasicAuthenticationFilter {
    public JWTAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain chain) throws IOException, ServletException {
        String tokenHeader = request.getHeader(JwtTokenUtil.TOKEN_HEADER);
        // 如果请求头中没有 Authorization 信息，直接放行
        if (StringUtils.isBlank(tokenHeader) || !tokenHeader.startsWith(JwtTokenUtil.TOKEN_PREFIX)) {
            chain.doFilter(request, response);
            return;
        }
        // 存在token，进行解析，并设置认证信息
        try {
            SecurityContextHolder.getContext().setAuthentication(getAuthentication(tokenHeader));
        } catch (TokenIsExpiredException e) {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            String reason = "统一处理，原因：" + e.getMessage();
            response.getWriter().write(new ObjectMapper().writeValueAsString(reason));
            response.getWriter().flush();
            return;
        }
        super.doFilterInternal(request, response, chain);
    }

    /**
     * 从 token 中获取用户信息并新建一个 token
     *
     * @param tokenHeader
     * @return
     */
    private UsernamePasswordAuthenticationToken getAuthentication(String tokenHeader) throws TokenIsExpiredException {
        String token = tokenHeader.replace(JwtTokenUtil.TOKEN_PREFIX, "");
        boolean expiration = JwtTokenUtil.isExpiration(token);
        if (expiration) {
            throw new TokenIsExpiredException("token timeout");
        }
        String username = JwtTokenUtil.getUsername(token);
        String role = JwtTokenUtil.getUserRole(token);
        if (StringUtils.isNotBlank(username)) {
            return new UsernamePasswordAuthenticationToken(username, null,
                    Collections.singleton(new SimpleGrantedAuthority(role)));
        }
        return null;
    }
}
