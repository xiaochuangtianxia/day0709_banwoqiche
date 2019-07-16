package com.qf.java1902.service;

import com.qf.java1902.pojo.SysUser;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by Administrator on 2019/7/11.
 */
public interface SysUserService {

    public List<SysUser> findOneByName(String username);

    public List<SysUser> findOneById(Integer id);

    public int updateOneUserByName(String username,String account,String email);

    public int updateOneUserPassword(String username,String oldPassword,String newPassword,String newPassword2);

}
