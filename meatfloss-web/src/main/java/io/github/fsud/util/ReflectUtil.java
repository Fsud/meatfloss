package io.github.fsud.util;

import io.github.fsud.mvc.RequestReflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by fankun on 2018/3/23.
 */
public class ReflectUtil {
    public static void invoke(RequestReflect requestReflect){
        Class clazz = requestReflect.getControllerClass();
        Method method = requestReflect.getReflectMethod();
        try {
            method.invoke(clazz.newInstance(),null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
