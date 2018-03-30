package person.summer.beans.support;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import person.summer.beans.BeanFactory;

/**
 * @author huangwenjun
 * @Date 2018年3月30日
 */
public class DefaultListableBeanFactory implements BeanFactory {

    // 单例
    private final Map<Class<?>, Object> singletonBeans = new ConcurrentHashMap<Class<?>, Object>();

    // 非单例
    private final Set<Class<?>> notSingletonBeans = new LinkedHashSet<>();

    // 自动注入

    public void addSingletonBean(Class<?> singletonClass, Object object) {
        singletonBeans.put(singletonClass, object);
    }

    public void addNotSingletonBean(Class<?> notSingletonClass) {
        notSingletonBeans.add(notSingletonClass);
    }

    public Object getBean(String name) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    public <T> T getBean(Class<T> requiredType) throws Exception {
        return (T) singletonBeans.get(requiredType);
    }

}
