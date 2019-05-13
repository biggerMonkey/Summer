package person.summer.beans.annotation;

/**
 * @author huangwenjun
 * @Date 2019年4月15日
 */
public enum MethodEnum {
    GET("GET"), POST("POST");
    String name;

    MethodEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
