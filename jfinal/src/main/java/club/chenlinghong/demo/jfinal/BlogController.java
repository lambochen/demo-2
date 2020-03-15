package club.chenlinghong.demo.jfinal;

import com.jfinal.aop.Before;
import com.jfinal.aop.Inject;
import com.jfinal.core.Controller;

/**
 * @Author lambo.chen.2306@gmail.com
 * @Date 2020/3/15 17:16
 * @Description TODO
 **/
@Before(BlogInterceptor.class)
public class BlogController extends Controller {

    @Inject
    BlogService service;

    public void index() {
        set("blogPage", service.paginate(getParaToInt(0, 1), 10));
        render("blog.html");
    }

    public void save() {
        getModel(Blog.class).save();
        redirect("/blog");
    }

    public void edit() {
        set("blog", service.findById(getParaToInt()));
    }

    public void update() {
        getModel(Blog.class).update();
        redirect("/blog");
    }

    public void delete() {
        service.deleteById(getParaToInt());
        redirect("/blog");
    }

}
