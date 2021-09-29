package com.lzz.back.shiro;

import com.lzz.back.mapper.UserMapper;
import com.lzz.back.token.JwtToken;
import com.lzz.back.util.StringUtil;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <p>
 *  加密
 * </p>
 *
 * @author lzz
 * @since 2021-09-23
 */
//密码验证器
@Component
public class MyCredentialsMatcher extends SimpleCredentialsMatcher {

    @Autowired
    private UserMapper userService;

    //使用自定义token
    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        //有token直接通过
        JwtToken jwtToken=(JwtToken) token;
        if (jwtToken.getPassword() == null){
            return true;
        }
        //获得用户输入的密码:(可以采用加盐(salt)的方式去检验)
        String inPassword = new String(jwtToken.getPassword());
        //获得数据库中的密码
        String username = String.valueOf(info.getPrincipals());
        //获取盐
        String slat = userService.getUserByUsername(username).getSalt();

        String dbPassword=(String) info.getCredentials();
        //进行密码的比对
        return this.equals(StringUtil.md5(inPassword + slat), dbPassword);
    }

}
