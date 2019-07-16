package com.qf.java1902.config;

import com.qf.java1902.shiro.MyRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2019/6/30.
 */
@Configuration
public class ShiroConfig {

    //创建自定义的realm对象
    @Bean(name = "myRealm")
    public MyRealm getRealm(){
        MyRealm myRealm = new MyRealm();
        return myRealm;
    }

    //创建安全管理器
    @Bean(name = "defaultWebSecurityManager")
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("myRealm") MyRealm myRealm){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(myRealm);
        return defaultWebSecurityManager;
    }

    //创建shiro权限管理器
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        shiroFilterFactoryBean.setLoginUrl("/index");//登陆页
        shiroFilterFactoryBean.setUnauthorizedUrl("/unauth");//无权访问时显示的页面
     //   Map<String,String> map=new HashMap<>();
      //  map.put("/首页","authc");//只有登录后才能访问
       // map.put("/会员管理","perms[会员管理]");//用户登录成功后，并且拥有会员管理权限才可访问
     //   shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }



}
