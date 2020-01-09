package com.learning.stream.producer.controller;

import com.learning.stream.producer.channel.SendMessageInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * 发送消息
 * @author wanglu
 * @date 2020/01/09
 */
@Slf4j
@RestController
public class SendMessageController {
    /**
     * 生成这流程：
     * 1. 创建发送消息的通道
     * 2. 生产投递消息
     * 3. 开启绑定（结合）
     */

    @Autowired
    private SendMessageInterface sendMessageInterface;

    /**
     * 生成并投递消息（生成这往通道中发送消息）
     */
    @GetMapping("/sendMessage")
    public String sendMessage() {
        String msg = UUID.randomUUID().toString();
        log.info("send message with content: {}", msg);

        Message message = MessageBuilder.withPayload(msg.getBytes()).build();
        sendMessageInterface.sendMsg().send(message);

        return msg;
    }

}
