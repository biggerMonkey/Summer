package person.hwj.Test.annoation.service.impl;

import person.hwj.Test.annoation.service.DepartmentService;
import person.summer.beans.annotation.Compant;

/**
 * @Description:
 * @Author: huangwenjun
 * @Date: 2019/5/10 11:52
 */
@Compant
public class DepartmentServiceImpl implements DepartmentService {
    @Override
    public String departmentList() {
        return "I am department list";
    }
}
