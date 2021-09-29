package com.lzz.back.mapper;

import com.lzz.back.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lzz
 * @since 2021-09-23
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    User getUserByUsername(String username);

    List<User> lookPerson(String username, String  roleName);

    List<User> getStudentListByCourseId(Integer courseId);

    List<User> getAllTeachersBySchoolId(Integer schoolId);
}
