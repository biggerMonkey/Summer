package person.summer.context.support;

import person.summer.beans.BeanFactory;
import person.summer.context.ApplicationContext;

/**
 * @author huangwenjun
 * @Date 2018年3月30日
 */
public class DefaultApplicationContext implements ApplicationContext {

    private BeanFactory beanFactory;

    private ClassPathBeanDefinitionScanner scanner;

    public DefaultApplicationContext() {
        this.scanner = new ClassPathBeanDefinitionScanner();
    }

    public void initApplicationContext(Class<?> tempClass) {
        try {
            beanFactory = scanner.scan(tempClass.getPackage().getName());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void initApplicationContext(String... basePackages) {
        try {
            beanFactory = scanner.scan(basePackages);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public <T> T getBean(Class<T> requiredType) throws Exception {
        return (T) beanFactory.getBean(requiredType);
    }
}
