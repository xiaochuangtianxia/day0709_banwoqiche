package com.qf.java1902.controller;

import com.qf.java1902.pojo.SysUser;
import com.qf.java1902.service.RemoteSysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2019/7/11.
 */
@Controller
public class PersonalCenterController {

    @Autowired
    public RemoteSysUserService remoteSysUserService;

    @RequestMapping(value = "/gerenzhongxin")
    public String personalCenter(HttpSession session, Model model){

        String date = (String) session.getAttribute("date2");
        model.addAttribute("date2",date);
        String username= (String) session.getAttribute("name2");
        model.addAttribute("name2",username);
        String roleName= (String) session.getAttribute("roleName2");
        model.addAttribute("roleName2",roleName);

        List<SysUser> sysUsers = remoteSysUserService.personalCenter(username+"");
        System.out.println(sysUsers);
        model.addAttribute("sysUsers",sysUsers);
        return "gerenzhongxin";
    }

    @RequestMapping(value = "/xiugaiziliao")
    public String xiugaiziliao(HttpServletRequest request,HttpSession session,Model model){

        String date = (String) session.getAttribute("date2");
        model.addAttribute("date2",date);
        String username= (String) session.getAttribute("name2");
        model.addAttribute("name2",username);
        String roleName= (String) session.getAttribute("roleName2");
        model.addAttribute("roleName2",roleName);

        String account = request.getParameter("account");
        String email = request.getParameter("email");

        remoteSysUserService.xiugaiziliao(username,account,email);
        List<SysUser> sysUsers = remoteSysUserService.personalCenter(username);
        model.addAttribute("sysUsers",sysUsers);
        return "gerenzhongxin";
    }

    @RequestMapping(value = "/xiugaimima")
    public String xiugaimima(HttpServletRequest request,HttpSession session,Model model){

        String date = (String) session.getAttribute("date2");
        model.addAttribute("date2",date);
        String username= (String) session.getAttribute("name2");
        model.addAttribute("name2",username);
        String roleName= (String) session.getAttribute("roleName2");
        model.addAttribute("roleName2",roleName);

        List<SysUser> sysUsers = remoteSysUserService.personalCenter(username);
        model.addAttribute("sysUsers",sysUsers);

        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");
        String newPassword2 = request.getParameter("newPassword2");

        if(newPassword.equals(newPassword2)){
            int i = remoteSysUserService.xiugaimima(username, oldPassword, newPassword, newPassword2);
            if(i==1){
                model.addAttribute("ss2","修改成功");
                return "xiugaimima";
            }
            if(i==0){
                model.addAttribute("ss2","您输入的旧密码有误！");
                return "xiugaimima";
            }
        }
        else {
            model.addAttribute("ss2","您输入的新密码，两次不一致！");
            return "xiugaimima";
        }
        return null;
    }

}
