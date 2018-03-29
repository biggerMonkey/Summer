package person.hwj.Test.jedis;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import person.hwj.Test.OkhttpUtils;

import com.alibaba.fastjson.JSON;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private RedisOperation redisOperation;

    @RequestMapping("/save")
    public String save() {
        System.out.println("save>>start");
        return String.valueOf(redisOperation.save());
    }

    @RequestMapping("/two/element")
    public String testTwoElement() {
        String url = "http://10.1.4.138:8085/third/common/lemon/two/element";
        Map<String, String> params = new HashMap<String, String>();
        params.put("idCard", "440104198911153796");
        params.put("name", "马戚伟");
        Map<String, String> header = new HashMap<String, String>();
        header.put("source", "kuaixin-k");
        String response = "null";
        try {
            response = OkhttpUtils.postJson(url, JSON.toJSONString(params), header);
            System.out.println(response);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return response;
    }
}
