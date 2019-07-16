package com.qf.java1902.controller;

import com.qf.java1902.pojo.OperateLog;
import com.qf.java1902.service.RemoteOperationLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2019/7/11.
 */
@Controller
public class OperationLogController {

    @Autowired
    public RemoteOperationLogService remoteOperationLogService;


    @RequestMapping(value = "/caozuorizhi")
    public String caozuorizhi(HttpSession session, Model model){

        String date = (String) session.getAttribute("date2");
        model.addAttribute("date2",date);
        String name= (String) session.getAttribute("name2");
        model.addAttribute("name2",name);
        String roleName= (String) session.getAttribute("roleName2");
        model.addAttribute("roleName2",roleName);
        return "caozuorizhi";
    }

    @RequestMapping(value = "/caozuorizhi2")
    @ResponseBody
    public Object caozuorizhi2(@RequestParam(value = "operatePerson",defaultValue = "") String operatePerson,
                               HttpSession session, HttpServletRequest request,Model model){

        String operatePerson2 = request.getParameter("operatePerson");

        List<OperateLog> opeationLogs = remoteOperationLogService.findOpeationLog(operatePerson2+"");
        model.addAttribute("opeationLogs",opeationLogs);
       return opeationLogs;
    }
}
