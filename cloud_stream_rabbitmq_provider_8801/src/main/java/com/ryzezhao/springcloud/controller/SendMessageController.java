package com.ryzezhao.springcloud.controller;

import com.ryzezhao.springcloud.common.Result;
import com.ryzezhao.springcloud.service.MessageProviderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SendMessageController {
    @Resource
    private MessageProviderService messageProviderService;

    @GetMapping(value = "/sendMessage")
    public Result sendMessage() {
        return Result.ok("成功",messageProviderService.send());
    }
}