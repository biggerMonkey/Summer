package person.hwj.Test.annoation.controller;

import person.hwj.Test.annoation.service.DepartmentService;
import person.hwj.Test.annoation.service.UserService;
import person.hwj.Test.ucenter.UserEntity;
import person.summer.beans.annotation.*;

/**
 * @author huangwenjun
 * @Date 2019年4月15日
 */
@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(path = "/info")
    public String userInfo() {
        System.out.println("阿弥陀佛");
        return "佛祖保佑！";
    }

    @RequestMapping(path = "/info2", method = MethodEnum.POST)
    public UserEntity userInfo2() {
        return userService.userInfo();
    }

    @RequestMapping(path = "/depatment")
    public String departmentList(String name, @PathVariable("age") String age) {
        return departmentService.departmentList();
    }
}
