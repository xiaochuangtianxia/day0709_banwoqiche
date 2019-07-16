package com.qf.java1902.service;

import com.qf.java1902.pojo.UserBean;
import com.qf.java1902.vo.EasyuiDataGridResult;

import java.util.List;

/**
 * Created by Administrator on 2019/6/30.
 */
public interface UserService {

    public UserBean findOneUserBean(String name);

    public List<UserBean> findAllUsers();

    public List<UserBean> findAllUsers(String state);

    public EasyuiDataGridResult findAllUsers(Integer page, Integer rowszhxmcn);

    public EasyuiDataGridResult findAllUsersByCondition(Integer page, Integer rows,String username,String gender,String startTime,String endTime);
}
