package person.hwj.Test.annoation.controller;

import person.hwj.Test.annoation.service.TestService;
import person.summer.beans.annotation.Autowired;
import person.summer.beans.annotation.RequestMapping;
import person.summer.beans.annotation.RestController;

/**
 * @author huangwenjun
 * @Date 2018年4月3日
 */
@RestController
@RequestMapping(path="/test")
public class TestController {

    @Autowired(name = "TestServiceImpl")
    private TestService testService;

    @RequestMapping(path="/my")
    public void myTest() {
        if (testService == null) {
            System.out.println("testService 注入失败！");
            return;
        }
        testService.test("TestController1");
    }
}
