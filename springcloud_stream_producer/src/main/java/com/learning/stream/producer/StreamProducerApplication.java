package com.learning.stream.producer;

import com.learning.stream.producer.channel.SendMessageInterface;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * 消息生成这启动类
 * @author wanglu
 * @date 2020/01/09
 */
@SpringBootApplication
@EnableEurekaClient
@EnableBinding(SendMessageInterface.class)
public class StreamProducerApplication {

    /**
     * EnableBinding注解绑定通道，也就是具体实现SendMessageInterface，将其实现类注入到spring容器中
     *
     * nested exception is org.springframework.amqp.AmqpConnectException: java.net.ConnectException: Connection refused (Connection refused)
     * 这个错误是由于没有开启rabbitmq导致的
     *
     * magic v1 does not support record headers
     * 这个错误是由于kafka版本太低造成，需要升级版本
     */

    public static void main(String[] args) {
        SpringApplication.run(StreamProducerApplication.class, args);
    }

}
