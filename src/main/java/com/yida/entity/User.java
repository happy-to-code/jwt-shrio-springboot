package com.yida.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户表(User)实体类
 *
 * @author makejava
 * @since 2020-04-05 18:53:42
 */
@Data
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
     * 用户名
     */
    private String username;

    /**
     * 盐
     */
    private String salt;

    /**
     * 注册时间
     */
    private Date regTime;


}
