package io.github.fsud.mvc;

import io.github.fsud.annotation.Controller;
import io.github.fsud.annotation.RequestMapping;
import io.github.fsud.util.ClassUtil;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by fankun on 2018/3/20.
 */
public class RequestMappingConfiguration {

    private static Map<Request,RequestReflect> requestReflectMap = new HashMap<>();


    public static void init() throws Exception {
        //获取根目录下的包含@Controller的所有class
        List<Class> classList = ClassUtil.getClassWithAnnotation(Controller.class,"io/suddenfora","io.suddenfora");

        //扫描每个class的所有方法，如果存在@RequestMapping注解，则新增一个RequestMapping
        for (Class clazz : classList) {
            String controllerUri = clazz.getClass().getAnnotation(RequestMapping.class).value();
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                if(method.isAnnotationPresent(RequestMapping.class)){
                    Request request = new Request(method.getAnnotation(RequestMapping.class),controllerUri);
                    if(requestReflectMap.containsKey(request)){
                        throw new Exception("duplicate");
                    }
                    RequestReflect requestReflect = new RequestReflect(clazz,method);
                    requestReflectMap.put(request,requestReflect);
                }
            }
        }
    }

    public static Map<Request, RequestReflect> getRequestReflectMap() {
        return requestReflectMap;
    }
}
