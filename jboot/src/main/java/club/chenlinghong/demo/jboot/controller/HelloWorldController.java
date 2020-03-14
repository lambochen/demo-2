package club.chenlinghong.demo.jboot.controller;

import io.jboot.web.controller.JbootController;
import io.jboot.web.controller.annotation.RequestMapping;

/**
 * @Author lambo.chen.2306@gmail.com
 * @Date 2020/3/15 0:00
 * @Description TODO
 **/
@RequestMapping("/hello")
public class HelloWorldController extends JbootController {

    /**
     * 访问路径：
     * http://127.0.0.1:8080/hello
     * http://127.0.0.1:8080/hello/index
     */
    public void index() {
        renderJson("{\"name\":123}");
    }

    /**
     * 访问路径：
     * http://127.0.0.1:8080/hello/index_01
     */
    public void index_01() {
        renderJson("{\"name\":456}");
    }

}
