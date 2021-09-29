package com.lzz.back.controller;


import com.alibaba.fastjson.JSON;
import com.lzz.back.entity.User;
import com.lzz.back.response.Result;
import com.lzz.back.service.UserService;
import com.lzz.back.token.JwtToken;
import com.lzz.back.util.JwtUtil;
import com.lzz.back.util.StringUtil;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

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
@RestController//@ResponseBody和@Controller的合集。用于定义控制器类，在spring项目中由控制器负责
               // 将用户发来的URL请求转发到对应的服务接口（service层），表示该方法的返回结果直接写入HTTP response body中，
              //  一般在异步获取数据时使用，用于构建RESTful的api
@RequestMapping("/user")//提供路由信息，负责URL到Controller中的具体函数的映射
public class UserController {
    @Autowired//自动导入依赖的bean
    private UserService userService;

      //自定义token登录

    @ApiOperation("登录")//构建Api文档的
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestBody User user) {
        if (user.getUsername() == null || user.getPassword() == null) {
            return JSON.toJSONString(new Result().setCode(500).setMessage("账号密码不能为空"));
        }
        Subject subject = SecurityUtils.getSubject();
        String token = JwtUtil.createJWT(user.getUsername(), "back", "user", 1000 * 60 * 60 * 24);
        JwtToken jwtToken = new JwtToken(token, user.getPassword());
        try {
            subject.login(jwtToken);
        } catch (UnknownAccountException e) {
            return JSON.toJSONString(new Result().setCode(401).setMessage("账号不存在"));
        } catch (IncorrectCredentialsException e) {
            return JSON.toJSONString(new Result().setCode(402).setMessage("密码错误"));
        }
        User backUser = userService.getUserByUsername(user.getUsername());
        Map<String, Object> map = new HashMap<>();
        map.put("user", backUser);
        map.put("token", token);
        return JSON.toJSONString(new Result().setCode(200).setMessage("登录成功").setData(map));
    }


    @ApiOperation("退出登录")
    @GetMapping("/logout")//封装了RequestMapping
    public Result logout() {
        SecurityUtils.getSubject().logout();
        return new Result().setCode(200).setMessage("成功退出");
    }

    @RequestMapping(value = "/getMenuList", method = RequestMethod.GET)
    public String getMenuList(String username) {
        if (StringUtils.isEmpty(username)) {
            return JSON.toJSONString(new Result().setCode(401).setMessage("未登录,请先登录"));
        }
        List<Map<String, Object>> list = userService.getMenuList(username);
        if (list == null) {
            return JSON.toJSONString(new Result().setCode(500).setMessage("获取错误"));
        } else {
            return JSON.toJSONString(new Result().setCode(200).setMessage("获取成功").setData(list));
        }
    }
    @RequiresPermissions("person:look")//权限注解
    @RequestMapping(value = "/lookPerson", method = RequestMethod.GET)
    public String getPerson(@Nullable String username, @Nullable String roleName, @Nullable String pageNum, @Nullable String pageSize) {
        System.out.println(25);
        if (StringUtils.isBlank(username)) {
            username = null;
        }
        if (StringUtils.isBlank(roleName)) {
            roleName = null;
        }
        Integer first = StringUtil.changeString(pageNum);
        Integer second = StringUtil.changeString(pageSize);
        Map<String, Object> list = userService.lookPerson(username, roleName, first, second);
        System.out.println(list);
        return JSON.toJSONString(new Result().setCode(200).setMessage("成功").setData(list));
    }

    @ApiOperation("获取学院所有老师")
    @RequestMapping(value = "/getTeachers", method = RequestMethod.GET)
    public String getTeachersBySchoolId(Integer schoolId) {
        List<User> list = userService.getAllTeachersBySchoolId(schoolId);
        return JSON.toJSONString(new Result().setCode(200).setData(list));
    }

}
