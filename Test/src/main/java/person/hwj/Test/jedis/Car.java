package person.hwj.Test.jedis;

import javax.annotation.PostConstruct;

public class Car {

    public Car() {
        System.out.println("init");
    }

    @PostConstruct
    public void beforeInit() {

    }
}
