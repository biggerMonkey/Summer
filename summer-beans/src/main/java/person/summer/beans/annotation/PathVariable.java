package person.summer.beans.annotation;

/**
 * @Description:
 * @Author: huangwenjun
 * @Date: 2019/5/10 16:24
 */
public @interface PathVariable {

    String name() default "";
    String value() default "";

}
