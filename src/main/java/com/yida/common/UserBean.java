package com.yida.common;

import lombok.Data;

import java.util.List;

/**
 * @author zhangyifei
 */
@Data
public class UserBean {
    private String username;

    private String password;

    /**
     * 角色名称
     */
    private List<String> roleNames;

    /**
     * 权限名称
     */
    private List<String> permissions;


}
