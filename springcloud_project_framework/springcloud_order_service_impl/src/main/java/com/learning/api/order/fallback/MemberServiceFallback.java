package com.learning.api.order.fallback;

import com.learning.api.member.domain.User;
import com.learning.api.order.feign.MemberFeignApi;
import org.springframework.stereotype.Component;

/**
 * 用于服务降级的类, 需要注入到spring容器中
 * @author wanglu
 * @date 2020/01/05
 */
@Component
public class MemberServiceFallback implements MemberFeignApi {
    public User getUser(String name) {
        return null;
    }

    public String timeoutMethod() {
        return "接口超时，通过类的方式实现服务降级！";
    }
}
