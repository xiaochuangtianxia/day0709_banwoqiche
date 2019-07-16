package com.qf.java1902.shiro;

import com.qf.java1902.pojo.UserBean;
import com.qf.java1902.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2019/6/30.
 */
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        Object principal = authenticationToken.getPrincipal();
        String name = (String) principal;
        UserBean oneUserBean = userService.findOneUserBean(name);
        SimpleAuthenticationInfo simpleAuthenticationInfo=null;
        if(oneUserBean!=null){
            simpleAuthenticationInfo = new SimpleAuthenticationInfo(oneUserBean.getUsername(), oneUserBean.getPassword(), this.getName());
        }
        return simpleAuthenticationInfo;
    }
}
