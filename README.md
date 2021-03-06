# SpringCloud(H版)学习

#### 项目介绍
主要是SpringCloud(H版)学习

（暂定）
SpringBoot版本：2.2.6.RELEASE
SpringCloud版本：Hoxton SR4
SpringCloudAlibaba版本：2.2.1.RELEASE
JDK版本：8
MySQL版本：5.7+
Maven版本：3.5+


服务注册中心：Eureka(不维护了)、Zookeeper、Consul、Nacos（重点、阿里的） 
服务调用：Ribbon（不太好）、LoadBalancer 
服务调用2：Feign(不维护了)、OpenFeign 
服务降级：Hystrix(不维护了)、Resilience4j（国外多）、Sentinel（建议、阿里的） 
服务网关：Zuul(不维护了)、GateWay 
服务配置：Config(不维护了)、阿波罗、Nacos（建议、阿里的） 
服务总线：Bus(不维护了)、Nacos（建议、阿里的）



#### 建议
1. 所有yml的配置文件，改为yaml




#### 使用说明
H_SpringCloud父模块

1.  cloud_payment_service_8001                                  SpringCloud(H版)：服务提供者8001
2.  cloud_consumer_order_80                                     SpringCloud(H版)：服务消费者80
3.  cloud_eureka_server_7001                                    SpringCloud(H版)：服务注册与发现Eureka7001
4.  cloud_eureka_server_7002                                    SpringCloud(H版)：服务注册与发现Eureka7002 
5.  cloud_provider_payment_8002                                 SpringCloud(H版)：服务提供者8002
6.  cloud_provider_payment_8004                                 SpringCloud(H版)：服务提供者8004（以Zookeeper作为注册中心）
7.  cloud_consumer_order_zookeeper_84                           SpringCloud(H版)：服务消费者84（以Zookeeper作为注册中心）
8.  cloud_provider_payment_8006                                 SpringCloud(H版)：服务提供者8006（以Consul作为注册中心）
9.  cloud_consumer_order_consul_86                              SpringCloud(H版)：服务消费者86（以Consul作为注册中心）
10. cloud_api_commons                                           SpringCloud(H版)：公共包
11. cloud_consumer_order_feign_80                               SpringCloud(H版)：服务消费者80（OpenFeign使用模块）
12. cloud_provider_payment_hystrix_8001                         SpringCloud(H版)：Hystrix服务提供者8001
13. cloud_consumer_order_feign_hystrix_80                       SpringCloud(H版)：Hystrix服务消费者80
14. cloud_hystrix_dashboard_18001                               SpringCloud(H版)：Hystrix图形化Dashboard18001
15. cloud_gateway_server_8888                                   SpringCloud(H版)：GateWay路由网关8888
16. cloud_config_server_3300                                    SpringCloud(H版)：Config+Bus配置中心3300
17. cloud_config_client_3310                                    SpringCloud(H版)：Config+Bus配置客户端3310
18. cloud_config_client_3311                                    SpringCloud(H版)：Config+Bus配置客户端3311
19. cloud_stream_rabbitmq_provider_8801                         SpringCloud(H版)：Spring Cloud Stream消息生产者8801
20. cloud_stream_rabbitmq_consumer_8802                         SpringCloud(H版)：Spring Cloud Stream消息消费者8802
21. cloud_stream_rabbitmq_consumer_8803                         SpringCloud(H版)：Spring Cloud Stream消息消费者8803
22. cloud_alibaba_provider_payment_9001                        	SpringCloud(H版)：服务提供者9001（以Nacos作为注册中心）
23. cloud_alibaba_provider_payment_9002                         SpringCloud(H版)：服务提供者9002（以Nacos作为注册中心）
24. cloud_alibaba_consumer_payment_83                           SpringCloud(H版)：服务消费者83（以Nacos作为注册中心）
25. cloud_alibaba_config_nacos_client_3377                      SpringCloud(H版)：配置客户端3377（以Nacos作为配置中心）








#### 参与贡献
1. RyzeZhao





#### 相关链接
SpringBoot版本选择
    https://spring.io/projects/spring-cloud#overview
SpringBoot详细版本选择
    start.spring.io/actuator/info
SpringCloud版本（点当前版本	Reference Doc. 可以看到官方推荐版本的SpringBoot）
    https://spring.io/projects/spring-cloud#learn
SpringCloud Alibaba版本
    https://www.mvnjar.com/com.alibaba.cloud/spring-cloud-alibaba-dependencies/jar.html
SpringCloud Alibaba版本选型
    https://github.com/alibaba/spring-cloud-alibaba/wiki/%E7%89%88%E6%9C%AC%E8%AF%B4%E6%98%8E



