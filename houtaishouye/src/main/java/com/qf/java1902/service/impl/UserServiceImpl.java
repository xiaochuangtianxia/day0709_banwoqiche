package com.qf.java1902.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.java1902.mapper.UserMapper;
import com.qf.java1902.pojo.UserBean;
import com.qf.java1902.pojo.UserExample;
import com.qf.java1902.service.UserService;
import com.qf.java1902.vo.EasyuiDataGridResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2019/6/30.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserBean findOneUserBean(String name) {
        return userMapper.findOneUserBean(name);
    }

    @Override
    public List<UserBean> findAllUsers() {
        return userMapper.findAllUsers();
    }

    @Override
    public List<UserBean> findAllUsers(String state) {
        return userMapper.findAllUsersByState(state);
    }

    @Override
    public EasyuiDataGridResult findAllUsers(Integer page, Integer rows) {

        //在原查询基础上添加分页查询功能,在查询用户之前使用
        PageHelper.startPage(page,rows);
        //System.out.println("111=="+PageHelper.startPage(page,rows));
        List<UserBean> allUsers = userMapper.findAllUsers();
        PageInfo<UserBean> pageInfo=new PageInfo<>(allUsers);//从数据集合中提取分页信息,获得当前页的信息

        //System.out.println("222==="+pageInfo);
        EasyuiDataGridResult dataGridResult = new EasyuiDataGridResult();
        dataGridResult.setRows(allUsers);//设置当前页结果集
        Long total = pageInfo.getTotal();//获取总记录数
        //System.out.println("333=="+total);
        dataGridResult.setTotal(total);
        //System.out.println("444==="+dataGridResult);
        return dataGridResult;
    }


    @Override
    public EasyuiDataGridResult findAllUsersByCondition(Integer page, Integer rows,
                                                        String username,String gender,String startTime,String endTime) {

        //在原查询基础上添加分页查询功能,在查询用户之前使用
        PageHelper.startPage(page,rows);
        //System.out.println("111=="+PageHelper.startPage(page,rows));
        List<UserBean> allUsersByCondition = userMapper.findAllUsersByCondition(username, gender, startTime, endTime);
        PageInfo<UserBean> pageInfo=new PageInfo<>(allUsersByCondition);//从数据集合中提取分页信息,获得当前页的信息

        //System.out.println("222==="+pageInfo);
        EasyuiDataGridResult dataGridResult = new EasyuiDataGridResult();
        dataGridResult.setRows(allUsersByCondition);//设置当前页结果集
        Long total = pageInfo.getTotal();//获取总记录数
        //System.out.println("333=="+total);
        dataGridResult.setTotal(total);
        //System.out.println("444==="+dataGridResult);
        return dataGridResult;
    }
}
