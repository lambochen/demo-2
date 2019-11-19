package club.chenlinghong.demo.kafka.imooc.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description 返回对象
 * @Author Lambo Chen
 * @Date 2019/11/12 21:22
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response implements Serializable {

    private static final long serialVersionUID = -7555113506245577408L;

    private int code;

    private String message;
}
