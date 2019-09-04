package club.chenlinghong.demo.rambo.ternaryoperator;

import org.junit.Test;

/**
 * @Description 三目运算符Demo
 * @Author chenlinghong
 * @Date 2019/9/3 8:25
 */
public class TernaryOperatorDemo {

    /**
     * https://blog.csdn.net/chensanwa/article/details/100498077
     */

    /**
     * 三目运算符使用
     */
    public void ternaryOperator() {
        boolean switchLog = true;
        // 基本类型
        int intValue = switchLog ? 1 : 0;
        // 引用类型
        String strValue = switchLog ? "true" : "false";
    }

    @Test
    public void intInteger() {
        boolean switchLog = true;
        Integer oneExpre = null;
        Integer result = switchLog ? oneExpre : new Integer(0);
        System.out.println(result);
    }
}
