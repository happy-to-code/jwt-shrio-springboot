package com.yida.controller;

import com.alibaba.fastjson.JSONObject;
import com.yida.common.ResponseBean;
import com.yida.dto.UserDTO;
import com.yida.service.UserService;
import com.yida.util.JWTUtil;
import com.yida.util.UnauthorizedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Describle:
 * @Author: zhangyifei
 * @Date: 2020/4/5 23:03
 */
@RestController
@Slf4j
public class LoginController {
    @Resource
    private UserService userService;

    @PostMapping("/login")
    public ResponseBean login(@RequestBody JSONObject requestJson) {
        log.info("用户登录");
        String username = requestJson.getString("username");
        String password = requestJson.getString("password");
        UserDTO userBean = userService.getByUseName(username);
        if (null != userBean && userBean.getPassword().equals(password)) {
            return new ResponseBean(200, "Login success", JWTUtil.sign(username, password));
        } else {
            throw new UnauthorizedException("用户名或者密码错误！");
        }
    }

}
