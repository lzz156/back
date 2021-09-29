package com.lzz.back;

import com.lzz.back.mapper.CourseMapper;
import com.lzz.back.mapper.PermissionMapper;
import com.lzz.back.mapper.TermMapper;
import com.lzz.back.service.RoleService;
import com.lzz.back.service.UserService;
import com.lzz.back.util.StringUtil;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = BackApplication.class)
class BackApplicationTests {

    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;
    @Autowired
    private PermissionMapper permissionMapper;
    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private TermMapper termMapper;

    @Test
    void contextLoads() {
        System.out.println(StringUtil.md5("1234"+"wcwad12"));
    }
    @Test
    void testMapper(){
        System.out.println(courseMapper.getThisStartCourses(6));
    }

    @Test
    void testService(){
        System.out.println(userService.getMenuList("zhangsan"));
    }

}
