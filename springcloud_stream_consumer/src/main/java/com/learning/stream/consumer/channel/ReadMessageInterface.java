package com.learning.stream.consumer.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * 消费消息的通道
 * @author wanglu
 * @date 2020/01/09
 */
public interface ReadMessageInterface {

    /**
     * 读取消息的通道, my_stream_channel为通道名称
     */
    @Input("my_stream_channel")
    SubscribableChannel readMsg();

}
