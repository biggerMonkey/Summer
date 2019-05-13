package person.summer.context;

import person.summer.core.env.ControllerClass;

/**
 * @author huangwenjun
 * @Date 2018年3月29日
 */
public interface ApplicationContext {

    public void initApplicationContext(String... basePackages);

    public <T> T getBean(Class<T> requiredType) throws Exception ;

    public ControllerClass getControlleClass(String uri);
}
