package com.ryzezhao.springcloud.controller;

import com.ryzezhao.springcloud.common.Result;
import com.ryzezhao.springcloud.service.TAccountService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;

@RestController
public class AccountController {

    @Resource
    private TAccountService tAccountService;

    /**
     * 扣减账户余额
     */
    @PostMapping("/account/decrease/{userId}/{money}")
    public Result decrease(@PathVariable("userId") String userId,@PathVariable("money")  BigDecimal money){
        return tAccountService.decrease(userId, money) ? Result.ok("扣减账户余额成功！") : Result.error("扣减账户余额失败！");
    }
}