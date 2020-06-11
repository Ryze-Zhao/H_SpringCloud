package com.ryzezhao.springcloud.service;

import org.springframework.messaging.Message;


public interface ReceiveMessageListener {
    void input(Message<String> message);
}