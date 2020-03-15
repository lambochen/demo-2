package club.chenlinghong.demo.jfinal;


import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

/**
 * @Author lambo.chen.2306@gmail.com
 * @Date 2020/3/15 17:19
 * @Description TODO
 **/
public class BlogInterceptor implements Interceptor {
    @Override
    public void intercept(Invocation inv) {
        System.out.println("before interceptor " + inv.getActionKey());
        inv.invoke();
        System.out.println("after interceptor " + inv.getActionKey());
    }
}
