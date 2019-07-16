package com.qf.java1902.mapper;

import com.qf.java1902.pojo.UserBean;
import com.qf.java1902.vo.EasyuiDataGridResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by Administrator on 2019/6/30.
 */
@Mapper
public interface UserMapper {
    public UserBean findOneUserBean(String name);

    public List<UserBean> findAllUsers();

    public List<UserBean> findAllUsersByState(String state);

    public List<UserBean> findAllUsersByCondition(@Param("username") String username, @Param("gender") String gender, @Param("startTime") String startTime, @Param("endTime") String endTime);
}
