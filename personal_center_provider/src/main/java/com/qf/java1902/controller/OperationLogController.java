package com.qf.java1902.controller;

import com.qf.java1902.pojo.OperateLog;
import com.qf.java1902.service.OperationLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2019/7/12.
 */
@Controller
public class OperationLogController {

    @Autowired
    private OperationLogService operationLogService;

    @RequestMapping(value = "/caozuorizhi2/{operatePerson}")
    @ResponseBody
    public List<OperateLog> findOpeationLog(@PathVariable("operatePerson") String operatePerson){
        List<OperateLog> operateLogs = operationLogService.findOpeationLog(operatePerson);
        return operateLogs;
    };
}
