package person.summer.core.env;

import person.summer.beans.annotation.MethodEnum;

import java.lang.reflect.Method;

/**
 * @Description:
 * @Author: huangwenjun
 * @Date: 2019/5/9 18:26
 */
public class ControllerClass {
    private String url;
    private MethodEnum methodEnum;
    private Class classInfo;
    private Method method;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public MethodEnum getMethodEnum() {
        return methodEnum;
    }

    public void setMethodEnum(MethodEnum methodEnum) {
        this.methodEnum = methodEnum;
    }

    public Class getClassInfo() {
        return classInfo;
    }

    public void setClassInfo(Class classInfo) {
        this.classInfo = classInfo;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }
}
