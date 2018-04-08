package person.hwj.Test.annoation;

import person.hwj.Test.annoation.service.TestService;
import person.summer.beans.annotation.Autowired;
import person.summer.beans.annotation.Compant;
import person.summer.beans.annotation.ScopeEnum;

/**
 * @author huangwenjun
 * @Date 2018年3月22日
 */
@Compant(type = ScopeEnum.PROTOTYPE)
public class NotSingleTest implements Parent {

    @Autowired
    private TestService testService;

    @MyAnnoation(info = "I am method info")
    public void add() {

    }

    @Override
    public void say() {
        testService.test("NotSingleTest");
        System.out.println("MyTest say!!!!!!!" + testService);
    }
}
