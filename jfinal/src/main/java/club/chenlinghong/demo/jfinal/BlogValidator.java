package club.chenlinghong.demo.jfinal;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

/**
 * @Author lambo.chen.2306@gmail.com
 * @Date 2020/3/15 17:25
 * @Description TODO
 **/
public class BlogValidator extends Validator {
    @Override
    protected void validate(Controller c) {
        validateRequiredString("blog.title", "titleMsg", "请输入标题");
        validateRequiredString("blog.content", "contentMsg", "请输入内容");
    }

    @Override
    protected void handleError(Controller c) {
        c.keepModel(Blog.class);
    }
}
