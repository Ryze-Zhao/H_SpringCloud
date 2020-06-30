package com.ryzezhao.springcloud.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ryzezhao.springcloud.entities.TAccount;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TAccountMapper extends BaseMapper<TAccount> {
}