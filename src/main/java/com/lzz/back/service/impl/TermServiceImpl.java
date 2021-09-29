package com.lzz.back.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzz.back.entity.Term;
import com.lzz.back.mapper.TermMapper;
import com.lzz.back.service.TermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lzz
 * @since 2021-09-23
 */
@Service
public class TermServiceImpl extends ServiceImpl<TermMapper, Term> implements TermService {

    @Autowired
    private TermMapper termMapper;

    @Override
    public List<Term> getAllTerm() {
        return termMapper.getAllTerm();
    }

    @Override
    public void setThisTerm(Integer termId) {
        List<Term> terms = termMapper.selectList(null);
        for (Term term : terms) {
            term.setTermStatus(0);
            termMapper.updateById(term);
        }
        Term term = termMapper.selectById(termId);
        term.setTermStatus(1);
        termMapper.updateById(term);

    }
}
