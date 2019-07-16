package com.qf.java1902.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2019/7/13.
 */
@Controller
public class XinzengzixunController {

    @RequestMapping(value = "/xinzengzixun")
    public String xinzengzixun(){
        return "xinzengzixun";
    }
}
