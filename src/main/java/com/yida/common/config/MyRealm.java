package com.yida.common.config;


import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.yida.common.JWTToken;
import com.yida.dto.UserDTO;
import com.yida.entity.Permission;
import com.yida.entity.Role;
import com.yida.service.UserService;
import com.yida.util.JWTUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Configuration
public class MyRealm extends AuthorizingRealm {
    @Resource
    private UserService userService;


    /**
     * 必须重写此方法，不然Shiro会报错
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    /**
     * 只有当需要检测用户权限的时候才会调用此方法，例如checkRole,checkPermission之类的
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = JWTUtil.getUsername(principals.toString());
        // 根据用户名获取用户角色 权限信息
        UserDTO user = userService.getByUseName(username);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        // 获取角色
        List<String> roleNames = getRoleNameList(user.getRoleList());
        for (String roleName : roleNames) {
            simpleAuthorizationInfo.addRole(roleName);
        }

        // 获取权限
        List<String> permissions = getPermissionList(user.getPermissionList());
        simpleAuthorizationInfo.addStringPermissions(new HashSet<>(permissions));
        return simpleAuthorizationInfo;
    }

    /**
     * 获取权限
     *
     * @param permissionList
     * @return
     */
    private List<String> getPermissionList(List<Permission> permissionList) {
        List<String> permissions = new ArrayList<>(permissionList.size());
        for (Permission permission : permissionList) {
            if (StringUtils.isNotBlank(permission.getPerCode())) {
                permissions.add(permission.getPerCode());
            }
        }
        return permissions;
    }

    /**
     * 获取角色名称
     *
     * @param roleList
     * @return
     */
    private List<String> getRoleNameList(List<Role> roleList) {
        List<String> roleNames = new ArrayList<>(roleList.size());
        for (Role role : roleList) {
            roleNames.add(role.getName());
        }
        return roleNames;
    }

    /**
     * 默认使用此方法进行用户名正确与否验证，错误抛出异常即可。
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws AuthenticationException {
        String token = (String) auth.getCredentials();
        // 解密获得username，用于和数据库进行对比
        String username = JWTUtil.getUsername(token);
        if (username == null) {
            throw new AuthenticationException("token invalid");
        }

        UserDTO userBean = userService.getByUseName(username);
        if (userBean == null) {
            throw new AuthenticationException("User didn't existed!");
        }

        if (!JWTUtil.verify(token, username, userBean.getPassword())) {
            throw new AuthenticationException("Username or password error");
        }

        return new SimpleAuthenticationInfo(token, token, "my_realm");
    }
}
