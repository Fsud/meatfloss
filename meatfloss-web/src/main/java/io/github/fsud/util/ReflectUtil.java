package io.github.fsud.util;

import io.github.fsud.mvc.RequestReflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by fankun on 2018/3/23.
 */
public class ReflectUtil {
    public static void invoke(RequestReflect requestReflect, HttpServletRequest request, HttpServletResponse response){
        Class clazz = requestReflect.getControllerClass();
        Method method = requestReflect.getReflectMethod();
        try {
            method.invoke(clazz.newInstance(),request,response);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
