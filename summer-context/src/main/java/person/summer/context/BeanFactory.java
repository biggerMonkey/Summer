package person.summer.context;

/**
 * @author huangwenjun
 * @Date 2018年3月29日
 */
public interface BeanFactory {

    Object getBean(String name) throws Exception;

    <T> T getBean(Class<T> requiredType) throws Exception;
}
