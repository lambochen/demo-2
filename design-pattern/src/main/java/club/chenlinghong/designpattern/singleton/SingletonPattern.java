package club.chenlinghong.designpattern.singleton;

/**
 * @Author lambo.chen.2306@gmail.com
 * @Date 2020/4/25 23:22
 * @Description 单例模式 通用代码，线程安全
 **/
public class SingletonPattern {

    /**
     * 饿汉模式初始化
     */
    private static final SingletonPattern SINGLETON_PATTERN = new SingletonPattern();

    // 限制产生多个对象
    private SingletonPattern() {
    }

    /**
     * 获取对象实例
     */
    public static SingletonPattern getInstance() {
        return SINGLETON_PATTERN;
    }

    // 类中其他方法，尽量是 static
    public static void doSomething() {
    }

}
