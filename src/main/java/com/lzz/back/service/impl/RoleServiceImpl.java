package com.lzz.back.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzz.back.entity.Role;
import com.lzz.back.mapper.RoleMapper;
import com.lzz.back.service.RoleService;
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
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {


    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Set<String> getAllRoleNamesByUsername(String username) {
        return roleMapper.selectAllRoleNamesByUsername(username);
    }
}
