package person.summer.beans.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author huangwenjun
 * @Date 2019年4月15日
 */
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface RestController{

    String name() default "";

    ScopeEnum type() default ScopeEnum.SINGLETON;

    boolean lazy() default false;
}
