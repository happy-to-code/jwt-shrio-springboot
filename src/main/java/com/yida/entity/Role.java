package com.yida.entity;

import java.io.Serializable;

/**
 * 角色表(Role)实体类
 *
 * @author makejava
 * @since 2020-04-05 18:53:42
 */
public class Role implements Serializable {
    private static final long serialVersionUID = -53136244988311795L;
    /**
    * ID
    */
    private Integer id;
    /**
    * 角色名称
    */
    private String name;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
