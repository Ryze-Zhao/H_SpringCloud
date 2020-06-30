package com.ryzezhao.springcloud.remote;

import com.ryzezhao.springcloud.common.Result;
import com.ryzezhao.springcloud.remote.fallback.TAccountServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@FeignClient(value = "seata-account-service", fallback = TAccountServiceFallback.class)
public interface TAccountService {

    @PostMapping(value = "/account/decrease/{userId}/{money}")
    Result decrease(@PathVariable("userId") String userId, @PathVariable("money")  BigDecimal money);


}