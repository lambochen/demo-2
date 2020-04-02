package club.chenlinghong.demo.spring.imooc.ioc;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author lambo.chen.2306@gmail.com
 * @Date 2020/4/2 0:00
 * @Description 自定义 IoC 容器
 * <p>
 * 约定：
 * 1、所有 IoC 注入均为构造器注入
 * 2、被依赖的 bean 需要优先创建
 * 3、所有 Bean 的生命周期交由 IoC 容器管理
 **/
public class IoCContainer {

    private Map<String, Object> beans = new ConcurrentHashMap<>();

    /**
     * 根据 beanId 获取 Bean
     *
     * @param beanId
     * @return
     */
    public Object getBean(String beanId) {
        return beans.get(beanId);
    }

    /**
     * 委托 ioc 容器创建 bean
     *
     * @param clazz        要创建的 bean 的 class
     * @param beanId
     * @param paramBeanIds bean 的 class 构造方法所需要的参数的 beanId 
     */
    public void setBean(Class<?> clazz, String beanId, String... paramBeanIds) {
        // 1. 组装构造方法所需要的参数值
        Object[] paramValues = new Object[paramBeanIds.length];
        for (int i = 0; i < paramBeanIds.length; i++) {
            paramValues[i] = beans.get(paramBeanIds[i]);
        }
        // 2. 调用构造方法实例化 bean
        Object bean = null;
        for (Constructor<?> constructor : clazz.getConstructors()) {
            try {
                bean = constructor.newInstance(paramValues);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        if (bean == null) {
            throw new RuntimeException("创建 bean 失败");
        }
        beans.put(beanId, bean);
    }
}
