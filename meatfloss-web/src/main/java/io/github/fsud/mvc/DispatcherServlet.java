package io.github.fsud.mvc;

import io.github.fsud.util.ReflectUtil;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by fankun on 2018/3/20.
 */
@WebServlet(urlPatterns = "/*", loadOnStartup = 0)
public class DispatcherServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        try {
            RequestMappingConfiguration.init();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uri = request.getRequestURI();
        Map<Request, RequestReflect> mapping = RequestMappingConfiguration.getRequestReflectMap();
        try {
            Request requestEntry = new Request(request.getRequestURI(), request.getMethod());
            mapping.forEach((requestM,requestReflectM)->{
                if (requestM.equals(requestEntry)){
                    ReflectUtil.invoke(requestReflectM);
                }
            });
        }
        catch (Exception e) {

        }
    }
}
