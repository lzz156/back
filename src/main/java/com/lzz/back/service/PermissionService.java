package com.lzz.back.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lzz.back.entity.Permission;

import java.util.Set;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lzz
 * @since 2021-09-23
 */
public interface PermissionService extends IService<Permission> {
    //通过用户名获取所有权限码
    Set<String> getAllPermissionByUsername(String username);
}
