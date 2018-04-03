package person.summer.context.support;

import java.util.Set;

import person.summer.beans.support.DefaultListableBeanFactory;
import person.summer.context.ApplicationContext;

/**
 * @author huangwenjun
 * @Date 2018年3月30日
 */
public class DefaultApplicationContext implements ApplicationContext {

    private DefaultListableBeanFactory beanFactory;

    private ClassPathBeanDefinitionScanner scanner;

    public DefaultApplicationContext() {
        this.scanner = new ClassPathBeanDefinitionScanner();
        this.beanFactory = new DefaultListableBeanFactory();
    }

    public void initApplicationContext(Class<?> tempClass) {
        initApplicationContext(tempClass.getPackage().getName());
    }

    public void initApplicationContext(String... basePackages) {
        try {
            // 扫描所有class
            Set<Class<?>> classes = scanner.scan(basePackages);
            // 初始化bean
            beanFactory.initBean(classes);
            beanFactory.autowireBean();
            // Controller初始化
            // tomcat初始化
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public <T> T getBean(Class<T> requiredType) throws Exception {
        return (T) beanFactory.getBean(requiredType);
    }
}
