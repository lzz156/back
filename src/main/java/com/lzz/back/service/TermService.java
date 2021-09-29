package com.lzz.back.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lzz.back.entity.Term;

import java.util.List;

public interface TermService extends IService<Term> {

    List<Term> getAllTerm();
    void setThisTerm(Integer termId);

}
