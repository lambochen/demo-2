package club.chenlinghong.demo.kafka.imooc.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description 消息实体
 * @Author Lambo Chen
 * @Date 2019/11/12 21:16
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageEntity implements Serializable {

    private static final long serialVersionUID = 2644328368056886322L;

    private String title;

    private String body;

}
