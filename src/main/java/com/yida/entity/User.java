package com.yida.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 用户表(User)实体类
 *
 * @author makejava
 * @since 2020-04-05 18:53:42
 */
public class User implements Serializable {
    private static final long serialVersionUID = 198050293852774656L;
    /**
    * ID
    */
    private Integer id;
    /**
    * 帐号
    */
    private String account;
    /**
    * 密码
    */
    private String password;
    /**
    * 昵称
    */
    private String username;
    /**
    * 注册时间
    */
    private Date regTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

}
