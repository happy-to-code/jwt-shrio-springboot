package com.yida.dto;

import com.yida.entity.Permission;
import com.yida.entity.Role;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 用户表(User)实体类
 *
 * @author makejava
 * @since 2020-04-05 18:53:42
 */
@Data
public class UserDTO implements Serializable {
    private static final long serialVersionUID = -7895253608686960270L;
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

    /**
     * 用户拥有的角色
     */
    private List<Role> roleList;

    /**
     * 用户拥有的权限
     */
    private List<Permission> permissionList;


}
