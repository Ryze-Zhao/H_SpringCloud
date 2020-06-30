package com.ryzezhao.springcloud.remote;

import com.ryzezhao.springcloud.common.Result;
import com.ryzezhao.springcloud.remote.fallback.TStorageServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "seata-storage-service", fallback = TStorageServiceFallback.class)
public interface TStorageService {

    @PostMapping(value = "/storage/decrease/{productId}/{count}")
    Result decrease(@PathVariable("productId") String productId, @PathVariable("count") Integer count);
}