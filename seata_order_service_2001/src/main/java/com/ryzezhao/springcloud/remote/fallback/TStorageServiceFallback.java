package com.ryzezhao.springcloud.remote.fallback;

import com.ryzezhao.springcloud.common.Result;
import com.ryzezhao.springcloud.remote.TStorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TStorageServiceFallback implements TStorageService {
    @Override
    public Result decrease(String productId, Integer count) {
        log.error("{}调用{}异常", TStorageServiceFallback.class.getName(), "decrease");
        return null;
    }
}