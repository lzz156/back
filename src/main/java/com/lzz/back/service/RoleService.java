package com.lzz.back.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lzz.back.entity.Role;

import java.util.Set;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lzz
 * @since 2021-09-23
 */
public interface RoleService extends IService<Role> {
     // 通过用户名获取所有角色名
    Set<String> getAllRoleNamesByUsername(String username);
}
