package com.qf.java1902.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2019/7/12.
 */
@Controller
public class GuanliyuanliebiaoController {

    @RequestMapping(value = "/guanliyuanliebiao")
    public String guanliyuanliebiao(){
        return "guanliyuanliebiao";
    }
}
