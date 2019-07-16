package com.qf.java1902.service;

import com.qf.java1902.pojo.SysUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by Administrator on 2019/7/11.
 */
//使用和发现服务场中的其他服务
@FeignClient(value="personal-provider")
public interface RemoteSysUserService {



    @RequestMapping(value = "/gerenzhongxin/{username}")
    public List<SysUser> personalCenter(@PathVariable("username") String username);

    /*
    @RequestMapping(value = "/gerenzhongxin/{id}")
    public List<SysUser> personalCenter(@PathVariable("id") Integer id);
*/

    @RequestMapping(value = "/xiugaiziliao")
    public int xiugaiziliao(@RequestParam("username") String username,
                            @RequestParam("account") String account,
                            @RequestParam("email") String email);


    @RequestMapping(value = "/xiugaimima")
    public int xiugaimima(@RequestParam("username") String username,
                          @RequestParam("oldPassword") String oldPassword,
                          @RequestParam("newPassword") String newPassword,
                          @RequestParam("newPassword2") String newPassword2);
}
