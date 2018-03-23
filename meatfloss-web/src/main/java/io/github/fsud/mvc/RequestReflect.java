package io.github.fsud.mvc;

import java.lang.reflect.Method;

/**
 * Created by fankun on 2018/3/20.
 */
public class RequestReflect {
    private Class controllerClass;
    private Method reflectMethod;
    private String mediaType = "application/json";

    public RequestReflect() {
    }

    public RequestReflect(Class controllerClass, Method reflectMethod) {
        this.controllerClass = controllerClass;
        this.reflectMethod = reflectMethod;
    }

    public Class getControllerClass() {
        return controllerClass;
    }

    public void setControllerClass(Class controllerClass) {
        this.controllerClass = controllerClass;
    }

    public Method getReflectMethod() {
        return reflectMethod;
    }

    public void setReflectMethod(Method reflectMethod) {
        this.reflectMethod = reflectMethod;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }
}
