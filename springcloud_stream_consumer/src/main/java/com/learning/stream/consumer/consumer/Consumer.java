package com.learning.stream.consumer.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

/**
 * 消费消息
 * @author wanglu
 * @date 2020/01/09
 */
@Slf4j
@Component
public class Consumer {

    @StreamListener("my_stream_channel")
    public void readMessage(String msg) {
        log.info("Consumer readMessage with content: {}", msg);
    }
}
