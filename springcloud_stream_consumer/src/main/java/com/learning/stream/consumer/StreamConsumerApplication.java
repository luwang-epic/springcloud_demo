package com.learning.stream.consumer;

import com.learning.stream.consumer.channel.ReadMessageInterface;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * 消费者启动类
 * @author wanglu
 * @date 2020/01/09
 */
@SpringBootApplication
@EnableEurekaClient
@EnableBinding(ReadMessageInterface.class)
public class StreamConsumerApplication {

    /**
     * EnableBinding注解绑定通道，也就是具体实现ReadMessageInterface，将其实现类注入到spring容器中
     */

    public static void main(String[] args) {
        SpringApplication.run(StreamConsumerApplication.class, args);
    }

}
