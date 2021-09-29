package com.lzz.back.mapper;

import com.github.jeffreyning.mybatisplus.base.MppBaseMapper;
import com.lzz.back.entity.ChooseCourse;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lzz
 * @since 2021-09-23
 */
@Mapper
public interface ChooseCourseMapper extends MppBaseMapper<ChooseCourse> {

    int deleteChooseCourse(int userId, int courseId);

    int insertChooseCourse(int userId, int courseId);

    ChooseCourse selectChooseCourseByCourseIdUserId(int userId, int courseId);

    int updateChooseCourse(int userId, int courseId, double usualGrade, double endGrade, double chooseStatus);
}
