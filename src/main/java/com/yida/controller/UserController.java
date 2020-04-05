package com.yida.controller;

import com.yida.entity.User;
import com.yida.service.UserService;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 用户表(User)表控制层
 *
 * @author makejava
 * @since 2020-04-05 18:53:43
 */
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    @RequiresPermissions(logical = Logical.OR, value = {"user:view", "user:edit"})
    public User selectOne(Integer id) {
        return this.userService.queryById(id);
    }

}
