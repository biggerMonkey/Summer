package person.hwj.Test.annoation.service.impl;

import person.hwj.Test.annoation.service.UserService;
import person.hwj.Test.ucenter.UserEntity;
import person.summer.beans.annotation.Compant;

/**
 * @Description:
 * @Author: huangwenjun
 * @Date: 2019/5/10 11:29
 */
@Compant
public class UserServiceImpl implements UserService {
    @Override
    public UserEntity userInfo() {
        UserEntity userEntity=new UserEntity();
        userEntity.setUserName("哇咔咔");
        return userEntity;
    }
}
