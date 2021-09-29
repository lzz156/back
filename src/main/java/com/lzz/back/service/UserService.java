package com.lzz.back.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lzz.back.entity.User;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lzz
 * @since 2021-09-23
 */
public interface UserService extends IService<User> {

    User getUserByUsername(String usernmae);

    List<Map<String, Object>>  getMenuList(String username);

    Map<String, Object> lookPerson(String username, String roleName, Integer pageNum, Integer pageSize);

    List<User> getStudentListByCourseId(Integer courseId);

    List<User> getAllTeachersBySchoolId(Integer schoolId);

    List<Map<String, Object>> getStudentsGradeByCourseId(Integer courseId);
}
