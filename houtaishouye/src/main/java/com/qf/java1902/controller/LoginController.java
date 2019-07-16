package com.qf.java1902.controller;

import com.qf.java1902.pojo.UserBean;
import com.qf.java1902.service.UserService;
import com.qf.java1902.utils.ImgCode;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


/**
 * Created by Administrator on 2019/6/29.
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/shouye")
    public String shouye(UserBean userBean, HttpSession session, Model model){
        String randomcodekey = (String) session.getAttribute(ImgCode.RANDOMCODEKEY);
        String verificationCode = userBean.getVerificationCode();
        if(userBean!=null){
            if(verificationCode.equalsIgnoreCase(randomcodekey)){
                try {
                    Subject subject = SecurityUtils.getSubject();
                    UsernamePasswordToken token = new UsernamePasswordToken(userBean.getUsername(),userBean.getPassword());
                    subject.login(token);
                    if(subject.isAuthenticated()){
                        UserBean oneUserBean = userService.findOneUserBean(userBean.getUsername());
                        LocalDate localDate = LocalDate.now();//获取当前时间
                        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyy-MM-dd");//制定格式化规则
                        String date = localDate.format(dateTimeFormatter); //将当前时间格式化
                        model.addAttribute("date2",date);
                        session.setAttribute("date2",date);
                        model.addAttribute("name2",userBean.getUsername());
                        session.setAttribute("name2",userBean.getUsername());
                        model.addAttribute("roleName2",oneUserBean.getRoleName());
                        session.setAttribute("roleName2",oneUserBean.getRoleName());
                        return "shouye";
                    }
                } catch (AuthenticationException e) {
                    model.addAttribute("ss3","有户名或密码错误");
                    return "index";
                }
            }   else {
                model.addAttribute("ss2","验证码有误！");
                return "index";
            }
        }

        return null;
    }

    @RequestMapping(value="/getImage" ,method= RequestMethod.GET)
    public void getVerifyImage(HttpServletRequest request, HttpServletResponse response){
        ImgCode imgCode = new ImgCode();
        imgCode.getRandcode(request,response);

    }


}
