package com.qf.java1902.controller;

import com.qf.java1902.pojo.UserBean;
import com.qf.java1902.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2019/7/13.
 */
@Controller
public class ZixunguanliController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/caogaoxiang")
    public String caogaoxiang( HttpServletRequest request, HttpSession session, Model model){

        String date = (String) session.getAttribute("date2");
        model.addAttribute("date2",date);
        String name= (String) session.getAttribute("name2");
        model.addAttribute("name2",name);
        String roleName= (String) session.getAttribute("roleName2");
        model.addAttribute("roleName2",roleName);

            List<UserBean> users = userService.findAllUsers();
            model.addAttribute("users",users);
            return "caogaoxiang";

    }

    @RequestMapping(value = "/caogaoxiang2{state}")
    public String caogaoxiang2(@PathVariable("state") String state, HttpServletRequest request, HttpSession session, Model model){

        String date = (String) session.getAttribute("date2");
        model.addAttribute("date2",date);
        String name= (String) session.getAttribute("name2");
        model.addAttribute("name2",name);
        String roleName= (String) session.getAttribute("roleName2");
        model.addAttribute("roleName2",roleName);

        if("1".equals(state)){
            List<UserBean> users = userService.findAllUsers();
            model.addAttribute("users",users);
            model.addAttribute("state",state);
            return "caogaoxiang";
        }   if("2".equals(state)){
            List<UserBean> users = userService.findAllUsers("未提交");
            model.addAttribute("users",users);
            model.addAttribute("state",state);
            return "caogaoxiang";
        }
        if("3".equals(state)){
            List<UserBean> users = userService.findAllUsers("未通过");
            model.addAttribute("users",users);
            model.addAttribute("state",state);
            return "caogaoxiang";
        }
        return null;
    }

}
