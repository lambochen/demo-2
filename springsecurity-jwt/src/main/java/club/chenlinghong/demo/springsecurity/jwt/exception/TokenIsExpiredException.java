package club.chenlinghong.demo.springsecurity.jwt.exception;

/**
 * @Author lambo.chen.2306@gmail.com
 * @Date 2019/12/16 10:15 下午
 * @Description 超时
 **/
public class TokenIsExpiredException extends Exception {

    public TokenIsExpiredException() {
    }

    public TokenIsExpiredException(String message) {
        super(message);
    }

    public TokenIsExpiredException(String message, Throwable cause) {
        super(message, cause);
    }

    public TokenIsExpiredException(Throwable cause) {
        super(cause);
    }

    public TokenIsExpiredException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
