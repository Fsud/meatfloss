package io.suddenfora;

import io.github.fsud.annotation.Controller;
import io.github.fsud.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by fankun on 2018/3/20.
 */
@Controller
@RequestMapping(value = "/we")
public class SampleController {

    @RequestMapping(value = "/led")
    public void test(HttpServletRequest request, HttpServletResponse response) throws Exception{
        response.getWriter().write("123");
        response.getWriter().flush();
    }

}
