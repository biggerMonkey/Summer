package person.summer.core.env;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import person.summer.core.util.StringUtils;

/**
 * @author huangwenjun
 * @Date 2018年4月8日
 */
@SuppressWarnings("rawtypes")
public class MutablePropertySources implements PropertySources {


    private final List<PropertySource<?>> propertySourceList =
            new CopyOnWriteArrayList<PropertySource<?>>();


    public MutablePropertySources() {}

    /**
     * Create a new {@code MutablePropertySources} from the given propertySources object, preserving
     * the original order of contained {@code PropertySource} objects.
     */
    public MutablePropertySources(PropertySources propertySources) {
        this();
        for (PropertySource<?> propertySource : propertySources) {
            addLast(propertySource);
        }
    }

    public boolean contains(String name) {
        return this.propertySourceList.contains(new PropertySource(name));
    }

    public PropertySource<?> get(String name) {
        int index = this.propertySourceList.indexOf(new PropertySource(name));
        return (index != -1 ? this.propertySourceList.get(index) : null);
    }

    public Iterator<PropertySource<?>> iterator() {
        return this.propertySourceList.iterator();
    }

    /**
     * Add the given property source object with highest precedence.
     */
    public void addFirst(PropertySource<?> propertySource) {
        removeIfPresent(propertySource);
        this.propertySourceList.add(0, propertySource);
    }

    /**
     * Add the given property source object with lowest precedence.
     */
    public void addLast(PropertySource<?> propertySource) {
        removeIfPresent(propertySource);
        this.propertySourceList.add(propertySource);
    }

    /**
     * Add the given property source object with precedence immediately higher than the named
     * relative property source.
     */
    public void addBefore(String relativePropertySourceName, PropertySource<?> propertySource) {
        assertLegalRelativeAddition(relativePropertySourceName, propertySource);
        removeIfPresent(propertySource);
        int index = assertPresentAndGetIndex(relativePropertySourceName);
        addAtIndex(index, propertySource);
    }

    /**
     * Add the given property source object with precedence immediately lower than the named
     * relative property source.
     */
    public void addAfter(String relativePropertySourceName, PropertySource<?> propertySource) {
        assertLegalRelativeAddition(relativePropertySourceName, propertySource);
        removeIfPresent(propertySource);
        int index = assertPresentAndGetIndex(relativePropertySourceName);
        addAtIndex(index + 1, propertySource);
    }

    /**
     * Return the precedence of the given property source, {@code -1} if not found.
     */
    public int precedenceOf(PropertySource<?> propertySource) {
        return this.propertySourceList.indexOf(propertySource);
    }

    /**
     * Remove and return the property source with the given name, {@code null} if not found.
     * 
     * @param name the name of the property source to find and remove
     */
    public PropertySource<?> remove(String name) {
        int index = this.propertySourceList.indexOf(new PropertySource(name));
        return (index != -1 ? this.propertySourceList.remove(index) : null);
    }

    /**
     * Replace the property source with the given name with the given property source object.
     * 
     * @param name the name of the property source to find and replace
     * @param propertySource the replacement property source
     * @throws IllegalArgumentException if no property source with the given name is present
     * @see #contains
     */
    public void replace(String name, PropertySource<?> propertySource) {
        int index = assertPresentAndGetIndex(name);
        this.propertySourceList.set(index, propertySource);
    }

    /**
     * Return the number of {@link PropertySource} objects contained.
     */
    public int size() {
        return this.propertySourceList.size();
    }

    @Override
    public String toString() {
        String[] names = new String[this.size()];
        for (int i = 0; i < size(); i++) {
            names[i] = this.propertySourceList.get(i).getName();
        }
        return String.format("[%s]", StringUtils.arrayToCommaDelimitedString(names));
    }

    /**
     * Ensure that the given property source is not being added relative to itself.
     */
    protected void assertLegalRelativeAddition(String relativePropertySourceName,
            PropertySource<?> propertySource) {
        String newPropertySourceName = propertySource.getName();
        if (relativePropertySourceName.equals(newPropertySourceName)) {
            throw new IllegalArgumentException(String.format(
                    "PropertySource named [%s] cannot be added relative to itself",
                    newPropertySourceName));
        }
    }

    /**
     * Remove the given property source if it is present.
     */
    protected void removeIfPresent(PropertySource<?> propertySource) {
        this.propertySourceList.remove(propertySource);
    }

    /**
     * Add the given property source at a particular index in the list.
     */
    private void addAtIndex(int index, PropertySource<?> propertySource) {
        removeIfPresent(propertySource);
        this.propertySourceList.add(index, propertySource);
    }

    /**
     * Assert that the named property source is present and return its index.
     * 
     * @param name the {@linkplain PropertySource#getName() name of the property source} to find
     * @throws IllegalArgumentException if the named property source is not present
     */
    private int assertPresentAndGetIndex(String name) {
        int index = this.propertySourceList.indexOf(new PropertySource(name));
        if (index == -1) {
            throw new IllegalArgumentException(String.format(
                    "PropertySource named [%s] does not exist", name));
        }
        return index;
    }

}
