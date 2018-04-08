package person.summer.core.env;



/**
 * @author huangwenjun
 * @Date 2018年4月8日
 */
public interface PropertySources extends Iterable<PropertySource<?>> {
    boolean contains(String name);

    PropertySource<?> get(String name);
}
