package club.chenlinghong.designpattern.singleton;

/**
 * @Author lambo.chen.2306@gmail.com
 * @Date 2020/4/25 23:33
 * @Description 单例模式 非线程安全代码
 **/
public class SingletonPatternNonConcurrent {

    private static SingletonPatternNonConcurrent INSTANCE = null;

    private SingletonPatternNonConcurrent() {
    }

    public static SingletonPatternNonConcurrent getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SingletonPatternNonConcurrent();
        }
        return INSTANCE;
    }

    /**
     * 解决方法：
     * 在 getInstance 方法加 synchronized, 也可在 getInstance 方法内增加 synchronized 来实现
     */

}
