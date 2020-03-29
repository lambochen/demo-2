package club.chenlinghong.demo.springcloud.imooc.eureka.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

/**
 * @Author lambo.chen.2306@gmail.com
 * @Date 2020/3/29 23:57
 * @Description 自定义 路由服务前 filter
 *
 * 在过滤器中存储客户端发起请求的时间戳
 **/
@Component
public class PreRequestFilter extends ZuulFilter {

    /**
     * 指定过滤器类型
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /**
     * 定义过滤器的执行顺序，数值越小，优先级越高
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否启用当前过滤器
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤逻辑
     */
    @Override
    public Object run() throws ZuulException {
        // RequestContext, 用于在过滤器间传递消息
        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.set("startTime", System.currentTimeMillis());
        return null;
    }
}
