package com.yida.controller;

import com.yida.entity.Role;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.*;
import com.yida.service.RoleService;

import javax.annotation.Resource;

/**
 * 角色表(Role)表控制层
 *
 * @author makejava
 * @since 2020-04-05 18:53:42
 */
@RestController
@RequestMapping("role")
public class RoleController {
    /**
     * 服务对象
     */
    @Resource
    private RoleService roleService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    @RequiresRoles(value = {"guest","admin"},logical = Logical.AND)
    public Role selectOne(Integer id) {
        return this.roleService.queryById(id);
    }

}
