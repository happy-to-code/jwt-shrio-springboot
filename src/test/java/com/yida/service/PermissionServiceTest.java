package com.yida.service;

import com.yida.dto.UserDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Describle:
 * @Author: zhangyifei
 * @Date: 2020/4/5 22:49
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PermissionServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void getByRoleIdList() {
        UserDTO admin = userService.getByUseName("admin");
        System.out.println("admin = " + admin);
    }
}
