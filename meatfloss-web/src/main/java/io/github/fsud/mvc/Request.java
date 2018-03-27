package io.github.fsud.mvc;

import io.github.fsud.annotation.RequestMapping;
import io.github.fsud.exception.MethodNotSupportException;

/**
 * Created by fankun on 2018/3/20.
 */
public class Request {
    private String requestURI = "";
    private RequestMethod method = RequestMethod.GET;

    public Request() {
    }

    public Request(RequestMapping reqMapMethod,RequestMapping reqMapController) {
        StringBuilder sb = new StringBuilder();
        if(reqMapController!=null){
            sb.append(reqMapController.value());
        }if(reqMapMethod!=null){
            sb.append(reqMapMethod.value());
        }
        requestURI = sb.toString();
        if(reqMapMethod!=null){
            method = reqMapMethod.method();
        }
    }

    public Request(String uri,String requestMethod) throws MethodNotSupportException{
        requestURI = uri;
        method = RequestMethod.parse(requestMethod);
    }

    public String getRequestURI() {
        return requestURI;
    }

    public void setRequestURI(String requestURI) {
        this.requestURI = requestURI;
    }

    public RequestMethod getMethod() {
        return method;
    }

    public void setMethod(RequestMethod method) {
        this.method = method;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Request request = (Request) o;

        if (requestURI != null ? !requestURI.equals(request.requestURI) : request.requestURI != null) return false;
        return method == request.method;
    }

    @Override
    public int hashCode() {
        int result = requestURI != null ? requestURI.hashCode() : 0;
        result = 31 * result + (method != null ? method.hashCode() : 0);
        return result;
    }
}
