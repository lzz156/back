package com.lzz.back.controller;

import com.alibaba.fastjson.JSON;
import com.lzz.back.entity.ChooseCourse;
import com.lzz.back.entity.Course;
import com.lzz.back.entity.User;
import com.lzz.back.response.Result;
import com.lzz.back.service.ChooseCourseService;
import com.lzz.back.service.CourseService;
import com.lzz.back.service.UserService;
import com.lzz.back.util.StringUtil;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
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
@RestController
@RequestMapping("/grade")
public class GradeController {

    @Autowired
    private CourseService courseService;
    @Autowired
    private UserService userService;
    @Autowired
    private ChooseCourseService chooseCourseService;

    @ApiOperation("查看本学期课程成绩")
    @RequiresPermissions("grade:this")
    @RequestMapping(value = "/showThis", method = RequestMethod.GET)
    public String showThisGrade(Integer userId, @Nullable String pageNum, @Nullable String pageSize) {
        Integer first = StringUtil.changeString(pageNum);
        Integer second = StringUtil.changeString(pageSize);
        Map<String, Object> map = courseService.getThisGrade(userId, first, second);
        return JSON.toJSONString(new Result().setCode(200).setData(map));
    }

    @ApiOperation("查看历史课程成绩")
    @RequiresPermissions("grade:history")
    @RequestMapping(value = "/showHistory", method = RequestMethod.GET)
    public String showHistoryGrade(Integer userId, Integer term, @Nullable String pageNum, @Nullable String pageSize) {

        Integer first = StringUtil.changeString(pageNum);
        Integer second = StringUtil.changeString(pageSize);
        Map<String, Object> map = courseService.getHistoryGrade(userId, term, first, second);

        return JSON.toJSONString(new Result().setCode(200).setData(map));
    }

    @ApiOperation("任课老师查看学生成绩")
    @RequiresPermissions("grade_manage:in")
    @RequestMapping(value = "/showStudentsCourseGrade", method = RequestMethod.GET)
    public String showStudentsCourseGrade(Integer courseId) {
        List<Map<String, Object>> maps = userService.getStudentsGradeByCourseId(courseId);
        Map<String, Object> map = new HashMap<>();
        Course course = courseService.getById(courseId);
        User teacher = userService.getById(course.getTeacherId());
        map.put("list", maps);
        map.put("course", course);
        map.put("teacher", teacher);
        return JSON.toJSONString(new Result().setCode(200).setData(map));
    }

    @ApiOperation("录入成绩")
    @RequiresPermissions("grade_manage:in")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateGrade(@RequestBody ChooseCourse chooseCourse) {
        if (chooseCourse.getEndGrade() != null && chooseCourse.getUsualGrade() != null) {
            chooseCourse.setChooseStatus(1);
        }
        chooseCourseService.updateByMultiId(chooseCourse);
        return JSON.toJSONString(new Result().setCode(200).setMessage("修改成功"));
    }
}
