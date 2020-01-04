package com.learning.api.order.feign;

import com.learning.api.member.service.MemberService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

/**
 * 通过feign客户端调用member服务
 *         这里只需要集成MemberService即可，不需要直接写重复的代码
 * @author wanglu
 * @date 2020/01/04
 */
@Component
@FeignClient(value = "springcloud-framework-member")
public interface MemberFeignApi extends MemberService {
}
