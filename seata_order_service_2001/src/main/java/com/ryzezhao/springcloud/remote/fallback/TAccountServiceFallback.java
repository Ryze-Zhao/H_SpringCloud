package com.ryzezhao.springcloud.remote.fallback;

import com.ryzezhao.springcloud.common.Result;
import com.ryzezhao.springcloud.remote.TAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Slf4j
public class TAccountServiceFallback implements TAccountService {
    @Override
    public Result decrease(String userId, BigDecimal money) {
        log.error("{}调用{}异常", TAccountServiceFallback.class.getName(), "decrease");
        return null;
    }
}