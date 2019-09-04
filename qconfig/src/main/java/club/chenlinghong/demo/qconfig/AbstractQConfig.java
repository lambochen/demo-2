package club.chenlinghong.demo.qconfig;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * @Description Qconfig 基础配置文件
 * @Author linghongchen
 * @Date 2019-09-04 20:58
 **/
@Slf4j
public abstract class AbstractQConfig {

    /**
     * 本地存储Qconfig配置
     */
    protected Map<String, String> properties;

    /**
     * 获取String类型的属性
     *
     * @param key          qconfig key
     * @param defaultValue 默认值
     * @return Qconfig配置属性值
     */
    public String getValue(String key, String defaultValue) {
        String value = properties.get(key);
        if (StringUtils.isBlank(value)) {
            // 未获取到配置，返回默认配置
            log.warn("AbstractQConfig#getValue: key={} 读取配置失败", key);
            return defaultValue;
        }
        return value;
    }

    public int getValue(String key, int defaultValue) {
        String value = properties.get(key);
        if (StringUtils.isBlank(value)) {
            // 未获取到配置，返回默认配置
            log.warn("AbstractQConfig#getValue: key={} 读取配置失败", key);
            return defaultValue;
        }
        try {
            return Integer.valueOf(value);
        } catch (NumberFormatException e) {
            log.error("AbstractQConfig#getValue: exception={}", e);
            /**
             * TODO 此处返回了一个特殊值，可优化
             */
            return Integer.MIN_VALUE;
        }
    }

    public boolean getValue(String key, boolean defaultValue) {
        String value = properties.get(key);
        if (StringUtils.isBlank(value)) {
            // 未获取到配置，返回默认配置
            log.warn("AbstractQConfig#getValue: key={} 读取配置失败", key);
            return defaultValue;
        }
        return Boolean.valueOf(value);
    }

    public double getValue(String key, double defaultValue) {
        String value = properties.get(key);
        if (StringUtils.isBlank(value)) {
            log.warn("AbstractQconfig#getValue: key={} 读取配置失败", key);
            return defaultValue;
        }
        try {
            return Double.valueOf(value);
        } catch (NumberFormatException e) {
            log.error("AbstractQconfig#getValue: exception={}", e);
            /**
             * TODO 此处返回了一个特殊值，可优化
             */
            return Double.MIN_VALUE;
        }
    }

}
