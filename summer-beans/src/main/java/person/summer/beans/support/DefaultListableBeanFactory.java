package person.summer.beans.support;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import person.summer.beans.BeanFactory;
import person.summer.beans.annotation.Autowired;
import person.summer.beans.annotation.Compant;
import person.summer.beans.annotation.ScopeEnum;
import person.summer.core.util.StringUtils;

/**
 * @author huangwenjun
 * @Date 2018年3月30日
 */
public class DefaultListableBeanFactory implements BeanFactory {

    // 单例
    private final Map<Class<?>, Object> singletonBeans = new ConcurrentHashMap<Class<?>, Object>();

    // 非单例
    private final Set<Class<?>> prototypeBeans = new LinkedHashSet<>();

    private final Map<String, Class<?>> nameBeans = new ConcurrentHashMap<String, Class<?>>();

    // 自动注入

    public void addSingletonBean(Class<?> singletonClass, Object object) {
        singletonBeans.put(singletonClass, object);
    }

    public void addNotSingletonBean(Class<?> notSingletonClass) {
        prototypeBeans.add(notSingletonClass);
    }

    public void addNameBeans(String beanName, Class<?> beanClass) {
        nameBeans.put(beanName, beanClass);
    }

    public Object getBean(String name) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    public <T> T getBean(Class<T> requiredType) throws Exception {
        T t = (T) singletonBeans.get(requiredType);
        if (t == null) {
            if (prototypeBeans.contains(requiredType)) {// 是否包含改bean
                return autowireBean(requiredType, requiredType.newInstance());
            } else {
                return null;
            }
        }
        return t;
    }

    public void initBean(Set<Class<?>> classes) throws Exception {
        for (Class<?> tempClass : classes) {
            Annotation[] annotations = tempClass.getAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation instanceof Compant) {// 需要实例化
                    Compant compant = (Compant) annotation;
                    if (!StringUtils.isEmpty(compant.name())) {
                        addNameBeans(compant.name(), tempClass);
                    } else {
                        addNameBeans(tempClass.getName(), tempClass);
                    }
                    if (compant.type().equals(ScopeEnum.SINGLETON)) {// 单例
                        addSingletonBean(tempClass, tempClass.newInstance());
                    } else {
                        addNotSingletonBean(tempClass);
                    }
                }
            }
        }
    }

    public void autowireBean() throws Exception {
        for (Class<?> tempClass : singletonBeans.keySet()) {
            addSingletonBean(tempClass, autowireBean(tempClass, tempClass.newInstance()));
        }
    }

    private <T> T autowireBean(Class<?> tempClass, T t) throws Exception {
        Field[] fields = tempClass.getDeclaredFields();
        for (Field field : fields) {
            Autowired[] autowireds = field.getAnnotationsByType(Autowired.class);
            if (autowireds.length == 0) {
                return (T) tempClass.newInstance();
            } else {
                T isInterface = null;
                if (StringUtils.isEmpty(autowireds[0].name())) {
                    if (field.getType().isInterface()) {
                        isInterface = autowireByType(field.getType());
                    } else {
                        isInterface = (T) field.getType().newInstance();
                    }
                } else {
                    isInterface = autowireByName(autowireds[0].name());
                }
                T fieldT = (T) autowireBean(isInterface.getClass(), isInterface);
                field.setAccessible(true);
                field.set(t, fieldT);
                return t;

            }
        }
        return (T) tempClass.newInstance();
    }

    private <T> T autowireByType(Class<?> interfaceClass) throws Exception {
        for (Class<?> tempClass : singletonBeans.keySet()) {
            Class<?>[] classes = tempClass.getInterfaces();
            for (Class<?> temp : classes) {
                if (temp.getTypeName().equals(interfaceClass.getTypeName())) {
                    T t = (T) singletonBeans.get(tempClass);
                    if (t == null) {
                        t = (T) tempClass.newInstance();
                    }
                    return t;
                }
            }
        }
        for (Class<?> tempClass : prototypeBeans) {
            Class<?>[] classes = tempClass.getInterfaces();
            for (Class<?> temp : classes) {
                if (temp.getTypeName().equals(interfaceClass.getTypeName())) {
                    T t = (T) tempClass.newInstance();
                    return t;
                }
            }
        }
        return null;
    }

    private <T> T autowireByName(String name) throws Exception {
        for (String beanName : nameBeans.keySet()) {
            if (beanName.equals(name)) {
                return (T) nameBeans.get(name).newInstance();
            }
        }
        return null;
    }
}
