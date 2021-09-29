package com.lzz.back.exception;

import com.lzz.back.response.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lzz
 * @since 2021-09-23
 */
@Slf4j
@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(value = UnauthorizedException.class)
    public Result handler(UnauthorizedException e) {
        log.error("运行时异常：----------------{}", e.getMessage());
        return new Result().setCode(402).setMessage("无权限操作");
    }

    @ExceptionHandler(value = ExpiredCredentialsException.class)
    public Result handler(ExpiredCredentialsException e) {
        log.error("运行时异常：----------------{}", e.getMessage());
        return new Result().setCode(401).setMessage("登录已过期，请重新登录");
    }


    @ExceptionHandler(value = UnauthenticatedException.class)
    public Result handler(UnauthenticatedException e) {
        log.error("运行时异常：----------------{}", e);
        return new Result().setCode(401).setMessage("未登录");
    }

    @ExceptionHandler(value = UnknownAccountException.class)
    public Result handler(UnknownAccountException e) {
        log.error("运行时异常：----------------{}", e);
        return new Result().setCode(401).setMessage("未登录123");
    }
}
