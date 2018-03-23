package io.github.fsud.util;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by fankun on 2018/3/20.
 */
public class ClassUtil {

    private static final String URL_PROTOCOL_FILE = "file";
    private static final String SEPARATOR = "/";
    private static final String POINT = ".";
    private static ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

    public static void getClass(List<Class> classOfPath, String path, String packageName) throws IOException {
        Enumeration<URL> urls = classLoader.getResources(path);
        URL url = urls.nextElement();
        url = urls.nextElement();
        if (URL_PROTOCOL_FILE.equals(url.getProtocol())) {
            File[] classOrDictionaries = new File(url.getPath()).listFiles();
            for (File classOrDictionary : classOrDictionaries) {
                String fileName = classOrDictionary.getName();
                if (classOrDictionary.isDirectory()) {
                    String subPath = path + SEPARATOR + fileName;
                    String subPackageName = packageName + POINT + fileName;
                    getClass(classOfPath, subPath, subPackageName);
                }
                else {
                    Class clazz = load(packageName + POINT
                            + classOrDictionary.getName().substring(0, classOrDictionary.getName().indexOf(POINT)));
                    classOfPath.add(clazz);
                }
            }
        }
    }

    public static List<Class> getClassWithAnnotation(Class annotation,String path, String packageName) throws IOException{
        List<Class> classOfPath = new ArrayList<>();
        getClass(classOfPath,path,packageName);
        return classOfPath.stream().filter(clazz->clazz.isAnnotationPresent(annotation)).collect(Collectors.toList());
    }

    // private static void loadRequestMapping(Class clazz) {
    // if(clazz.isAnnotationPresent(Controller.class)){
    // Method[] methods = clazz.getMethods();
    // for (Method method : methods) {
    // if(method)
    // }
    // }
    // }

    /**
     * 通过反射加载类
     * 
     * @param classPath
     * @return
     */
    private static Class load(String classPath) {
        try {
            return Class.forName(classPath, false, classLoader);
        }
        catch (ClassNotFoundException ex) {
            return null;
        }
    }

}
