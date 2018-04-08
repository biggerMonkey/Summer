package person.hwj.Test.annoation.controller;

import person.hwj.Test.annoation.service.TestService;
import person.summer.beans.annotation.Autowired;
import person.summer.beans.annotation.Compant;

/**
 * @author huangwenjun
 * @Date 2018年4月3日
 */
@Compant
public class TestController {

    @Autowired(name = "TestServiceImpl")
    private TestService testService;

    public void myTest() {
        if (testService == null) {
            System.out.println("testService 注入失败！");
            return;
        }
        testService.test("TestController1");
    }
}
