package io.github.fsud.annotation;

import io.github.fsud.mvc.RequestMethod;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by fankun on 2018/3/20.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestMapping {
    String value() default "";
    RequestMethod method() default RequestMethod.GET;
    String media() default "application/json";

}
