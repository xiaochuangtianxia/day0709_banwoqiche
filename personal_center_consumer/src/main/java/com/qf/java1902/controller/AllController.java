package com.qf.java1902.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2019/7/10.
 */
@Controller
public class AllController {

    @RequestMapping(value = "/个人中心")
    public String personalCenter(){

        return "个人中心";
    }
}
