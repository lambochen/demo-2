package club.chenlinghong.demo.rambo.resttemplate;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @Author Lambo Chen
 * @Date 2019/12/9 9:52 下午
 * @Description RestTemplate 客户端
 **/
@Component
public class RestTemplateClient {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * post 方式，采用 json
     */
    public String postJson(String url, Object requestParam) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        HttpEntity<Object> request = new HttpEntity<>(JSON.toJSON(requestParam), headers);

        return restTemplate.postForObject(url, request, String.class);
    }

}
