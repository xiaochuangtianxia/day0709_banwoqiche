package com.qf.java1902.pojo;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;


/**
 * Created by Administrator on 2019/6/29.
 */
@Data
public class UserBean implements Serializable {

    private Integer id;
    private String username;
    private String password;
    private String verificationCode;
    private String account;
    private String nickname;
    private String gender;
    private Date registrationDate;
    private String roleName;
    private String operation;
    private String email;
    private String dept;
    private String state;
    private String button1;
    private String button2;
    private String button3;

}
