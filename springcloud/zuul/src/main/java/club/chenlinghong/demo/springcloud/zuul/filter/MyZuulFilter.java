package club.chenlinghong.demo.springcloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author linghongchen
 * @Date 2019/11/28 10:34 下午
 * @Description Zuul 过滤器
 **/
@Slf4j
@Component
public class MyZuulFilter extends ZuulFilter {

    /**
     * filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
     * <p>
     * pre：路由之前
     * routing：路由之时
     * post： 路由之后
     * error：发送错误调用
     */
    private static final String PRE = "pre";

    @Override
    public String filterType() {
        return PRE;
    }

    @Override
    public int filterOrder() {
        // 过滤的顺序
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        // 是否要过滤， true 代表需要过滤
        return true;
    }

    /**
     * 过滤器的具体逻辑
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURI().toString()));
        Object acccessToken = request.getParameter("token");
        if (acccessToken == null) {
            log.warn("token is empty");
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(401);
            try {
                requestContext.getResponse().getWriter().write("token is empty");
            } catch (Exception e) {
                log.error("token is empty. exception={}", e);
                return null;
            }
        }
        log.info("ok");
        return null;
    }
}
