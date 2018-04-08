package person.summer.core.env;


/**
 * @author huangwenjun
 * @Date 2018年4月8日
 */
public class PropertySource<T> {

    protected final String name;

    protected final T source;

    public PropertySource(String name, T source) {
        this.name = name;
        this.source = source;
    }

    @SuppressWarnings("unchecked")
    public PropertySource(String name) {
        this(name, (T) new Object());
    }

    public String getName() {
        return this.name;
    }

    public T getSource() {
        return this.source;
    }
}
