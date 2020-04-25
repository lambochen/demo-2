package club.chenlinghong.designpattern.factory;

/**
 * @Author lambo.chen.2306@gmail.com
 * @Date 2020/4/25 23:47
 * @Description Product 创建器
 **/
public interface Creator {

    <T extends Product> T create(Class<T> clazz);

}
