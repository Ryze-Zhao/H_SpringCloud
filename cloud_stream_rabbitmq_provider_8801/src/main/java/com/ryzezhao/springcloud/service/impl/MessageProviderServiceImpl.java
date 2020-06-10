package com.ryzezhao.springcloud.service.impl;

import com.ryzezhao.springcloud.service.MessageProviderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;


//定义消息的推送管道
@EnableBinding(Source.class)
@Slf4j
public class MessageProviderServiceImpl implements MessageProviderService {
    // 消息发送管道
    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        log.info("已发送的serial：{}",serial);
        return serial;
    }
}
