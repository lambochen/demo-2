package club.chenlinghong.designpattern.factory;

/**
 * @Author lambo.chen.2306@gmail.com
 * @Date 2020/4/25 23:49
 * @Description TODO
 **/
public class ConcreteCreator implements Creator {
    @Override
    public <T extends Product> T create(Class<T> clazz) {
        Product product = null;
        try {
            product = (Product) Class.forName(clazz.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return (T) product;
    }
}
