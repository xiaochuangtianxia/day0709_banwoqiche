package com.qf.java1902.controller;

import com.qf.java1902.pojo.SysUser;
import com.qf.java1902.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2019/7/11.
 */
@Controller
public class PersonalCenterController {

    @Autowired
    private SysUserService sysUserService;
    @RequestMapping(value = "/gerenzhongxin/{username}")
    @ResponseBody
    public List<SysUser> personalCenter(@PathVariable("username") String username){
        List<SysUser> sysUsers = sysUserService.findOneByName(username);
        return sysUsers;
    }

    @RequestMapping(value = "/xiugaiziliao")
    @ResponseBody
    public int xiugaiziliao(@RequestParam("username") String username,
                            @RequestParam("account") String account,
                            @RequestParam("email") String email){
        int i = sysUserService.updateOneUserByName(username,account,email);
        return i;
    }

    @RequestMapping(value = "/xiugaimima")
    @ResponseBody
    public int xiugaimima(@RequestParam("username") String username,
                          @RequestParam("oldPassword") String oldPassword,
                          @RequestParam("newPassword") String newPassword,
                          @RequestParam("newPassword2") String newPassword2){
        int i = sysUserService.updateOneUserPassword(username, oldPassword, newPassword, newPassword2);
        return i;
    }




}
