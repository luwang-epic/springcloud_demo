package com.learning.stream.producer.channel;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.SubscribableChannel;

/**
 * 创建发送消息的通道
 * @author wanglu
 * @date 2020/01/09
 */
public interface SendMessageInterface {

    /**
     * 创建发送消息的通道, my_stream_channel为通道名称
     */
    @Output("my_stream_channel")
    SubscribableChannel sendMsg();

}
