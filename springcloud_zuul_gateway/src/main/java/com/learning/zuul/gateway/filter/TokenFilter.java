package com.learning.zuul.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 网关过滤器
 * @author wanglu
 * @date 2020/01/06
 */
@Slf4j
@Component
public class TokenFilter extends ZuulFilter {
    /**
     * 表示请求过滤类型  pre：请求之前进行资信
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 表示过滤器执行顺序，当一个请求在同一个阶段的时候， 存在多个过滤器的时候，多个过滤器执行顺序
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    public boolean shouldFilter() {
        return true;
    }

    /**
     * 编写过滤器拦截业务逻辑代码
     * @return
     * @throws ZuulException
     */
    public Object run() throws ZuulException {
        log.info("TokenFilter run...");

        // 案例： 拦截所有的服务接口，判断服务接口上是否有传递userToken参数

        // 1.获取上线文  也可以通过注解的方式
        RequestContext requestContext = RequestContext.getCurrentContext();
        // 2.获取Request对象
        HttpServletRequest request = requestContext.getRequest();
        // 3.获取token，实际项目中，一般从请求头中获取
        String userToken = request.getParameter("userToken");
        if(StringUtils.isBlank(userToken)) {
            //不会继续执行，不会调用服务接口，网关服务直接响应给客户端
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseBody("userToken is null");
            requestContext.setResponseStatusCode(401);
            return null;
        }

        //正常执行调用其他服务接口...
        return null;
    }
}
