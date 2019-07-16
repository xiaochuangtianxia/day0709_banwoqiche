package com.qf.java1902.service.impl;

import com.qf.java1902.mapper.SysUserMapper;
import com.qf.java1902.pojo.SysUser;
import com.qf.java1902.pojo.SysUserExample;
import com.qf.java1902.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2019/7/11.
 */
@Service
public class SysUserServiceImpl implements SysUserService{

    @Resource
    private SysUserMapper sysUserMapper;
    @Override
    public List<SysUser> findOneByName(String username) {
        SysUserExample example=new SysUserExample();
        SysUserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<SysUser> sysUsers = sysUserMapper.selectByExample(example);
        //System.out.println("6==="+sysUsers);
        return sysUsers;
    }

    @Override
    public List<SysUser> findOneById (Integer id) {
        SysUserExample example=new SysUserExample();
        SysUserExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        List<SysUser> sysUsers = sysUserMapper.selectByExample(example);
        return sysUsers;
    }

    @Override
    public int updateOneUserByName(String username,String account,String email) {
        SysUserExample example = new SysUserExample();
        SysUserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        SysUser sysUser=new SysUser();
        sysUser.setAccount(account);
        sysUser.setEmail(email);
        //updateByExampleSelective方法，空值默认不做修改。updateByExample默认全部修改
        int i = sysUserMapper.updateByExampleSelective(sysUser, example);
        return i;
    }

    @Override
    public int updateOneUserPassword(String username,String oldPassword, String newPassword, String newPassword2) {
        SysUserExample example = new SysUserExample();
        SysUserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<SysUser> sysUsers = sysUserMapper.selectByExample(example);
        System.out.println("haohao=="+sysUsers);
        for(SysUser sysUser:sysUsers){
            if(oldPassword.equals(sysUser.getPassword())){
                sysUser.setPassword(newPassword);
                sysUserMapper.updateByExampleSelective(sysUser,example);
                return 1;
            }   else {
                return 0;
            }
        }
        return 2;
    }
}
