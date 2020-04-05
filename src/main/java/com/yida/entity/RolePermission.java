package com.yida.entity;

import java.io.Serializable;

/**
 * 角色资源表(RolePermission)实体类
 *
 * @author makejava
 * @since 2020-04-05 18:53:42
 */
public class RolePermission implements Serializable {
    private static final long serialVersionUID = 940072301224083845L;
    /**
    * ID
    */
    private Integer id;
    /**
    * 角色id
    */
    private Integer roleId;
    /**
    * 权限id
    */
    private Integer permissionId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

}
