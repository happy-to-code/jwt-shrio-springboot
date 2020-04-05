package com.yida.controller;

import com.yida.entity.Permission;
import com.yida.service.PermissionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 资源表(Permission)表控制层
 *
 * @author makejava
 * @since 2020-04-05 18:53:40
 */
@RestController
@RequestMapping("permission")
public class PermissionController {
    /**
     * 服务对象
     */
    @Resource
    private PermissionService permissionService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Permission selectOne(Integer id) {
        return this.permissionService.queryById(id);
    }

}
