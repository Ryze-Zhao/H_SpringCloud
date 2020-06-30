package com.ryzezhao.springcloud.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ryzezhao.springcloud.mapper.TStorageMapper;
import com.ryzezhao.springcloud.entities.TStorage;
import com.ryzezhao.springcloud.service.TStorageService;
import org.springframework.util.Assert;

@Service
@Slf4j
public class TStorageServiceImpl extends ServiceImpl<TStorageMapper, TStorage> implements TStorageService {
    @Override
    public boolean decrease(String productId, Integer count) {
        //一些判定不写了，自行补充
        TStorage tStorage = this.getById(productId);
        log.info("------->storage-service中扣减库存开始");
        tStorage.setResidue(tStorage.getResidue() - count);
        tStorage.setUsed(tStorage.getUsed() + count);
        log.info("------->storage-service中扣减库存结束");
        return this.saveOrUpdate(tStorage);
    }
}
