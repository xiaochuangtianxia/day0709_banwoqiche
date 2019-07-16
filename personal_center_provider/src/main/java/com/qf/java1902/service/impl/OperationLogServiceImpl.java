package com.qf.java1902.service.impl;

import com.qf.java1902.mapper.OperateLogMapper;
import com.qf.java1902.pojo.OperateLog;
import com.qf.java1902.pojo.OperateLogExample;
import com.qf.java1902.service.OperationLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2019/7/12.
 */
@Service
public class OperationLogServiceImpl implements OperationLogService {

    @Resource
    private OperateLogMapper operateLogMapper;

    @Override
    public List<OperateLog> findOpeationLog(String operatePerson) {
        OperateLogExample example = new OperateLogExample();
        OperateLogExample.Criteria criteria = example.createCriteria();
        criteria.andOperatePersonEqualTo(operatePerson);
        List<OperateLog> operateLogs = operateLogMapper.selectByExample(example);
        return operateLogs;

    }
}