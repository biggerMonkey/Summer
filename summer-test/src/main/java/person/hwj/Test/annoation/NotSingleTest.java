package person.hwj.Test.annoation;

import person.summer.beans.annotation.Compant;
import person.summer.beans.annotation.ScopeEnum;

/**
 * @author huangwenjun
 * @Date 2018年3月22日
 */
@Compant(type = ScopeEnum.NOTSINGLETON)
public class NotSingleTest implements Parent {

    @MyAnnoation(info = "I am field info")
    private String info;

    @MyAnnoation(info = "I am method info")
    public void add() {

    }

    @Override
    public void say() {
        System.out.println("MyTest say!!!!!!!");
    }
}
