package com.ryzezhao.springcloud.service.impl;

import com.ryzezhao.springcloud.service.ReceiveMessageListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;

@EnableBinding(Sink.class)
@Slf4j
public class ReceiveMessageListenerImpl implements ReceiveMessageListener {
    @Value("${server.port}")
    private String serverPort;

    @Override
    @StreamListener(Sink.INPUT)
    public void input(Message<String> message) {
        log.info("cloud_stream_rabbitmq_consumer_8802接收到消息:{} \t  port:{} ", message.getPayload(), serverPort);
    }
}