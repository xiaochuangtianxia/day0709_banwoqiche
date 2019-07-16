package com.qf.java1902.controller;

import com.qf.java1902.pojo.UserBean;
import com.qf.java1902.service.UserService;
import com.qf.java1902.vo.EasyuiDataGridResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2019/6/29.
 */
@Controller
public class MemberController {

    @RequestMapping("/wangjimima")
    public String wangjimima(){
        return "wangjimima";
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/huiyuanguanli")
    public String huiyuanguanli(@RequestParam(value = "zhxmcn",defaultValue = "") String username,
                                @RequestParam(value = "gender",defaultValue = "") String gender,
                                @RequestParam(value = "startTime",defaultValue = "") String startTime,
                                @RequestParam(value = "endTime",defaultValue = "") String endTime,
                                @RequestParam(value = "page",defaultValue = "1") Integer page,
                                @RequestParam(value = "rows",defaultValue = "10") Integer rows,
                                HttpSession session, Model model){

        String date = (String) session.getAttribute("date2");
        model.addAttribute("date2",date);
        String name= (String) session.getAttribute("name2");
        model.addAttribute("name2",name);
        String roleName= (String) session.getAttribute("roleName2");
        model.addAttribute("roleName2",roleName);

        huiyuanguanli2(username, gender, startTime, endTime, page, rows, session, model);

//        EasyuiDataGridResult users = userService.findAllUsers(page, rows);
//        System.out.println(users);
//        model.addAttribute("users",users);
        return "huiyuanguanli";
    }


    @RequestMapping(value = "/huiyuanguanli2")
    @ResponseBody
    public Object huiyuanguanli2(@RequestParam(value = "zhxmcn",defaultValue = "") String username,
                                 @RequestParam(value = "gender",defaultValue = "") String gender,
                                 @RequestParam(value = "startTime",defaultValue = "") String startTime,
                                 @RequestParam(value = "endTime",defaultValue = "") String endTime,
                                 @RequestParam(value = "page",defaultValue = "1") Integer page,
                                 @RequestParam(value = "rows",defaultValue = "10") Integer rows,
                                 HttpSession session, Model model){

        System.out.println(username);
        System.out.println(gender);
        System.out.println(startTime);
        System.out.println(endTime);

        EasyuiDataGridResult users= userService.findAllUsersByCondition(page, rows, username, gender, startTime, endTime);
        return users;
    }

    @RequestMapping(value = "/wodebaozuo")
    public String huiyuanxiangqing_wodezuojia(HttpSession session, Model model){

        String date = (String) session.getAttribute("date2");
        model.addAttribute("date2",date);
        String name= (String) session.getAttribute("name2");
        model.addAttribute("name2",name);
        String roleName= (String) session.getAttribute("roleName2");
        model.addAttribute("roleName2",roleName);

        return "huiyuanxiangqing_wodebaozuo";
    }

    @RequestMapping(value = "/会员详情_我的活动")
    public String huiyuanxiangqing_wodehuodong(){
        return "会员详情_我的活动";
    }

    @RequestMapping(value = "/会员详情_我的积分")
    public String huiyuanxiangqing_wodejifeng(){
        return "会员详情_我的积分";
    }

    @RequestMapping(value = "/会员详情_资讯收藏")
    public String huiyuanxiangqing_xixunshoucang(){
        return "会员详情_资讯收藏";
    }

    @RequestMapping(value = "/会员详情_关注车型")
    public String huiyuanxiangqing_guanzhuchexin(){
        return "会员详情_关注车型";
    }

    @RequestMapping(value = "/草稿箱_资讯")
    public String caogaoxiang_zixun(){
        return "草稿箱_资讯";
    }

    @RequestMapping(value = "/新增资讯")
    public String xinzengzixun(){
        return "新增资讯";
    }





}
