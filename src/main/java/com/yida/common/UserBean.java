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

    private List<String> roleNames;

    private List<String> permissions;


}
