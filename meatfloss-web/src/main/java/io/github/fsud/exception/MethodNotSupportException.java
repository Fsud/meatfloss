package io.github.fsud.exception;

import javax.servlet.ServletException;

/**
 * Created by fankun on 2018/3/23.
 */
public class MethodNotSupportException extends ServletException {
    public MethodNotSupportException(String message) {
        super(message);
    }
}
