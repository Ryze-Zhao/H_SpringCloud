package com.ryzezhao.springcloud.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ryzezhao.springcloud.entities.TOrder;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TOrderMapper extends BaseMapper<TOrder> {
}