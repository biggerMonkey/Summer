package person.hwj.Test.annoation.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import person.hwj.Test.annoation.service.TestService;
import person.summer.beans.annotation.Compant;

/**
 * @author huangwenjun
 * @Date 2018年4月3日
 */
@Compant(name = "TestServiceImpl")
public class TestServiceImpl implements TestService {

    private static Logger LOG = LoggerFactory.getLogger(TestServiceImpl.class);

    @Override
    public void test(String source) {
        System.out.println("我是TestServiceImpl得test方法:" + source);
    }
}
