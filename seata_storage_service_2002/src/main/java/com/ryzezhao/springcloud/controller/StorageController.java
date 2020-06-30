package com.ryzezhao.springcloud.controller;

import com.ryzezhao.springcloud.common.Result;
import com.ryzezhao.springcloud.service.TStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
public class StorageController {

    @Autowired
    private TStorageService tStorageService;

    /**
     * 扣减库存
     */
    @PostMapping("/storage/decrease/{productId}/{count}")
    public Result decrease(@PathVariable("productId") String productId, @PathVariable("count") Integer count){
        return tStorageService.decrease(productId, count) ? Result.ok("扣减库存成功！") : Result.error("扣减库存失败！");
    }
}