package com.qf.java1902.service;

import com.qf.java1902.pojo.OperateLog;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by Administrator on 2019/7/12.
 */
@FeignClient(value="personal-provider")
public interface RemoteOperationLogService {

    @RequestMapping(value = "/caozuorizhi2/{operatePerson}")
    public List<OperateLog> findOpeationLog(@PathVariable("operatePerson") String operatePerson);
}
