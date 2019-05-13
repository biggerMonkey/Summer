package person.summer.context.support;

import person.summer.context.ApplicationContext;
import person.summer.context.embed.tomcat.TomcatMain;
import person.summer.core.env.ControllerClass;

import java.util.Set;

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
            // 准备environment

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

    public void run() throws Exception{
        TomcatMain.init(this);
    }

    @Override
    public <T> T getBean(Class<T> requiredType) throws Exception {
        return (T) beanFactory.getBean(requiredType);
    }
    @Override
    public ControllerClass getControlleClass(String uri) {
        return beanFactory.getControlleClass(uri);
    }
}
