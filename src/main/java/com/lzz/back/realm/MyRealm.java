package com.lzz.back.realm;

import com.lzz.back.entity.User;
import com.lzz.back.service.PermissionService;
import com.lzz.back.service.RoleService;
import com.lzz.back.service.UserService;
import com.lzz.back.token.JwtToken;
import com.lzz.back.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * <p>
 *  Token使用
 * </p>
 *
 * @author lzz
 * @since 2021-09-23
 */
@Component
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;

    @Override
    //获得自己定义的token
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }
//根据名字查找权限：授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String)principalCollection.iterator().next();
        Set<String> roleNames = roleService.getAllRoleNamesByUsername(username);
        Set<String> permission = permissionService.getAllPermissionByUsername(username);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setRoles(roleNames);
        info.setStringPermissions(permission);
        return info;
    }
    //使用自定义token：验证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        JwtToken jwtToken = (JwtToken) authenticationToken;
        String token = (String) jwtToken.getPrincipal();
        Claims claims = JwtUtil.parseJWT(token);
        String username = claims.getId();
        User user = userService.getUserByUsername(username);
        if (user == null){
            return null;
        }
        return new SimpleAuthenticationInfo(username, user.getPassword(), getName());
    }

}
