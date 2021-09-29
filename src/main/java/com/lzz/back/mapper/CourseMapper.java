package com.lzz.back.mapper;

import com.lzz.back.entity.Course;
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
public interface CourseMapper extends BaseMapper<Course> {

    List<Course> getThisCourses(Integer userId);

    List<Course> getChooseCourseResult(Integer userId);

    List<Course> getHistoryCourses(Integer userId, Integer term);

    List<Course> getThisStartCourses(Integer userId);

    List<Course> getHistoryStartCourses(Integer userId, Integer term);

    List<Course> getAllStartCourses(Integer schoolId, Integer term);

    List<Course> getThisCoursesHasGrade(Integer userId);

    List<Course> getHistoryGrade(Integer userId, Integer term);
}
