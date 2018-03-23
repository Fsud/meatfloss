package io.suddenfora;

import io.github.fsud.annotation.Controller;
import io.github.fsud.annotation.RequestMapping;

/**
 * Created by fankun on 2018/3/20.
 */
@Controller
public class SampleController {

    @RequestMapping(value = "/led")
    public void test(){
        System.out.println(123);
    }

}
