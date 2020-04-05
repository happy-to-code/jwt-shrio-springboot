package com.yida.entity;

import java.io.Serializable;

/**
 * 用户角色表(UserRole)实体类
 *
 * @author makejava
 * @since 2020-04-05 18:53:43
 */
public class UserRole implements Serializable {
    private static final long serialVersionUID = 756572160116258912L;
    /**
    * ID
    */
    private Integer id;
    /**
    * 用户id
    */
    private Integer userId;
    /**
    * 角色id
    */
    private Integer roleId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

}
