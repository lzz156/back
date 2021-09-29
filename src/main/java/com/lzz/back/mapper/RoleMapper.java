package com.lzz.back.mapper;

import com.lzz.back.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.Set;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lzz
 * @since 2021-09-23
 */

@Mapper
public interface RoleMapper extends BaseMapper<Role> {

    Set<String> selectAllRoleNamesByUsername(String username);
}
