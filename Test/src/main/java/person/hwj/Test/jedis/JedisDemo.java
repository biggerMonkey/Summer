package person.hwj.Test.jedis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import person.hwj.Test.SpringContextUtil;

@SpringBootApplication
@ComponentScan({"person.hwj.Test.jedis"})
public class JedisDemo {

    public static void main(String[] args) {
        SpringApplication applicationWeb = new SpringApplication(JedisDemo.class);
        ApplicationContext contextWeb = applicationWeb.run(args);
        SpringContextUtil.setApplicationContext(contextWeb);
    }
}
