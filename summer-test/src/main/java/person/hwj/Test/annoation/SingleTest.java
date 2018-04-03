package person.hwj.Test.annoation;

import person.summer.beans.annotation.Compant;

/**
 * @author huangwenjun
 * @Date 2018年3月22日
 */
@Compant
public class SingleTest implements Parent {

    private String info;

    public void add() {

    }

    @Override
    public void say() {
        System.out.println("MyTest say!!!!!!!");
    }
}
