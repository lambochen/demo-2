package club.chenlinghong.demo.qconfig;

import org.springframework.stereotype.Component;
import qunar.tc.qconfig.client.spring.QConfig;

import java.util.Map;

/**
 * @Description Qconfig demo
 * @Author linghongchen
 * @Date 2019-09-02 21:42
 *
 * 使用说明：https://github.com/qunarcorp/qconfig
 **/
@Component
public class DemoConfig extends AbstractQConfig {

    /**
     * Qconfig读取配置
     */
    @QConfig("config.properties")
    public void setProperties(Map properties) {
        this.properties = properties;
    }


}
