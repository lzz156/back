package com.lzz.back.mapper;

import com.lzz.back.entity.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
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
public interface PermissionMapper extends BaseMapper<Permission> {
    Set<String> selectAllPermissionCodeByUsername(String username);

    List<Permission> selectFatherPermissionByUsername(String username);

    List<Permission> selectSubPermissionByFatherId(int fatherId);

}
