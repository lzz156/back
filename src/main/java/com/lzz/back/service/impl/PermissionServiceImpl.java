package com.lzz.back.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzz.back.entity.Permission;
import com.lzz.back.mapper.PermissionMapper;
import com.lzz.back.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lzz
 * @since 2021-09-23
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;
    @Override
    public Set<String> getAllPermissionByUsername(String username) {
        return permissionMapper.selectAllPermissionCodeByUsername(username);
    }
}
