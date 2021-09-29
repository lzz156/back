package com.lzz.back.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lzz.back.entity.Term;
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
public interface TermMapper extends BaseMapper<Term> {

    List<Term> getAllTerm();
}
