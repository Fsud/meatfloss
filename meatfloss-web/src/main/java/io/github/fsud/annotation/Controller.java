package io.github.fsud.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by fankun on 2018/3/20.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Controller {
    String value() default "";
}
