package person.hwj.Test.annoation.service.impl;

import person.hwj.Test.annoation.service.TestService;
import person.summer.beans.annotation.Compant;

/**
 * @author huangwenjun
 * @Date 2018年4月3日
 */
@Compant(name = "TestServiceImpl")
public class TestServiceImpl implements TestService {

    @Override
    public void test() {
        System.out.println("我是TestServiceImpl得test方法");
    }
}
