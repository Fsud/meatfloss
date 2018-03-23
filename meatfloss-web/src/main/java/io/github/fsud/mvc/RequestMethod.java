package io.github.fsud.mvc;

import io.github.fsud.exception.MethodNotSupportException;

/**
 * Created by fankun on 2018/3/20.
 */
public enum RequestMethod {
    GET,POT,POST,DELETE;

    public static RequestMethod parse(String requestMethod) throws MethodNotSupportException {
        for (RequestMethod method : RequestMethod.values()) {
            if(method.name().equals(requestMethod)){
                return method;
            }
        }
        throw new MethodNotSupportException("method not support");
    }
}
