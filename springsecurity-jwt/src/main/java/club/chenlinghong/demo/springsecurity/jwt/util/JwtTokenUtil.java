package club.chenlinghong.demo.springsecurity.jwt.util;

import com.google.common.collect.Maps;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

/**
 * @Author lambo.chen.2306@gmail.com
 * @Date 2019/12/16 8:03 下午
 * @Description JWT util
 **/
public class JwtTokenUtil {

    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";
    /**
     * 密钥
     */
    private static final String SECRET = "jwtlambochen";

    private static final String ISS = "lambo";

    // 角色的key
    private static final String ROLE_CLAIMS = "rol";

    /**
     * 过期时间 3600 s
     */
    private static final long EXPIRATION = 3600L;

    /**
     * 过期时间 remember
     */
    private static final long EXPIRATION_REMENBER = 604_800L;

    /**
     * 创建 token
     *
     * @param username   用户名（用户标识）
     * @param rememberMe 是否记住
     * @return JWT Token
     */
    public static String createToken(String username, String role,  boolean rememberMe) {
        long expiration = rememberMe ? EXPIRATION_REMENBER : EXPIRATION;
        Map<String, Object> map = Maps.newConcurrentMap();
        map.put(ROLE_CLAIMS, role);
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS512, SECRET)
                // 尽早set，可能会覆盖别的字段
                .setClaims(map)
                .setIssuer(ISS)
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration * 1000))
                .compact();
    }

    /**
     * 从 Token 获取 username
     *
     * @param token JWT Token
     */
    public static String getUsername(String token) {
        return getTokenBody(token).getSubject();
    }

    /**
     * 校验是否过期
     * @param token
     * @return
     */
    public static boolean isExpiration(String token) {
        return getTokenBody(token).getExpiration().before(new Date());
    }

    /**
     * 获取 JWT Token body
     * @param token
     * @return
     */
    private static Claims getTokenBody(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();
    }

    // 获取用户角色
    public static String getUserRole(String token){
        return (String) getTokenBody(token).get(ROLE_CLAIMS);
    }


}
