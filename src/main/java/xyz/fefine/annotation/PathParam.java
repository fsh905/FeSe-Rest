package xyz.fefine.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by feng_sh on 17-6-6.
 * 路径参数
 */
@Target(ElementType.PARAMETER)				//参数声明
@Retention(RetentionPolicy.RUNTIME)		//运行期间保留
public @interface PathParam {
    String value() default "";
}
