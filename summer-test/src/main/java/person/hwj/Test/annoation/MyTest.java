package person.hwj.Test.annoation;

import person.summer.beans.annotation.Autowired;
import person.summer.beans.annotation.Compant;

/**
 * @author huangwenjun
 * @Date 2018年3月22日
 */
@Compant
public class MyTest implements Parent {

    @MyAnnoation(info = "I am field info")
    @Autowired(info = "我是字段注释！！！！")
    private String info;

    @MyAnnoation(info = "I am method info")
    @Autowired(info = "我是方法注释！！！！")
    public void add() {

    }

    @Override
    public void say() {
        System.out.println("MyTest say!!!!!!!");
    }
}
