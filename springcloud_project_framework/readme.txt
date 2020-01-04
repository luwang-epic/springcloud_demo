微服务中的一般架构，该工程为父工程，一般eureka集群会单独搭建
    架构如下：
    springcloud_project_framework (父工程）
           springcloud_api_service （二级父工程）(只有接口，没有实现)
                springcloud_api_member_service (会员工程接口）
                springcloud_api_order_service (订单工程接口）
           springcloud_member_service_impl (会员api接口的实现, 引入springcloud_api_member_service工程)
           springcloud_order_service_impl (订单api接口的实现, 引入springcloud_api_order_service， 如果需要feign客户端调用member服务，可以直接引入springcloud_api_member_service工程)

        如果接口有一些公共的方法或者接口，可以单独抽取出一个common工程