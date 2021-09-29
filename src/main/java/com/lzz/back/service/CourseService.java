package com.lzz.back.service;

import com.lzz.back.entity.Course;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lzz
 * @since 2021-09-23
 */
public interface CourseService extends IService<Course> {

    Map<String, Object> getThisCourses(Integer userId, Integer pageNum, Integer pageSize);

    Map<String, Object> getChooseCourseResult(Integer userId, Integer pageNum, Integer pageSize);

    int deleteChooseCourse(Integer userId, Integer courseId);

    int insertChooseCourse(Integer userId, Integer courseId);

    boolean isContradict(Integer userId, Integer courseId);

    Map<String, Object> getHistoryCourses(Integer userId, Integer term, Integer pageNum, Integer pageSize);

    Map<String, Object> getThisStartCourses(Integer userId, Integer pageNum, Integer pageSize);

    Map<String, Object> getHistoryStartCourses(Integer userId, Integer term, Integer pageNum, Integer pageSize);

    Map<String, Object> getALLStartCourses(Integer schoolId, Integer term, Integer pageNum, Integer pageSize);

    void openChooseCourse();

    void closeChooseCourse();

    Map<String, Object> getThisGrade(Integer userId, Integer pageNum, Integer pageSize);

    Map<String, Object> getHistoryGrade(Integer userId, Integer term, Integer pageNum, Integer pageSize);
}
