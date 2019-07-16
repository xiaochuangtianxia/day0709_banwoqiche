package com.qf.java1902.service;

import com.qf.java1902.pojo.OperateLog;

import java.util.List;

/**
 * Created by Administrator on 2019/7/12.
 */
public interface OperationLogService {

    public List<OperateLog> findOpeationLog(String operatePerson);
}
