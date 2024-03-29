package com.lzz.back.controller;

import com.alibaba.fastjson.JSON;
import com.lzz.back.entity.Term;
import com.lzz.back.response.Result;
import com.lzz.back.service.TermService;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
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
@RequestMapping("/term")
public class TermController {

    @Autowired
    private TermService termService;

    @ApiOperation("获取所有学期列表")
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public String getAllTerm(@Nullable Integer notAll) {
        List<Term> list = termService.getAllTerm();
        Map<String, Object> map = new HashMap<>();
        for (Term term : list) {
            if (term.getTermStatus() == 1){
                map.put("this", term.getTermId());
            }
        }
        if (notAll == null) {
            list.add(0, new Term().setTermId(0).setTermName("全部"));
        }
        map.put("list", list);
        return JSON.toJSONString(new Result().setCode(200).setData(map));
    }

    @ApiOperation("设置当前学期")
    @RequiresPermissions("term:set")
    @RequestMapping(value = "/set", method = RequestMethod.GET)
    public String setThisTerm(Integer termId) {
        termService.setThisTerm(termId);
        return JSON.toJSONString(new Result().setCode(200).setMessage("设置成功"));
    }
}
