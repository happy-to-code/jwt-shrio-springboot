package com.yida.controller;

import com.yida.entity.RolePermission;
import org.springframework.web.bind.annotation.*;
import com.yida.service.RolePermissionService;

import javax.annotation.Resource;

/**
 * 角色资源表(RolePermission)表控制层
 *
 * @author makejava
 * @since 2020-04-05 18:53:42
 */
@RestController
@RequestMapping("rolePermission")
public class RolePermissionController {
    /**
     * 服务对象
     */
    @Resource
    private RolePermissionService rolePermissionService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public RolePermission selectOne(Integer id) {
        return this.rolePermissionService.queryById(id);
    }

}
