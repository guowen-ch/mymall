package com.gwen.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Description：
 * Created By guowen
 */

/**@SpringCloudApplication
 * 其中@EnableZuulProxy是@EnableZuulServer的加强，
 * .@SpringCloudApplication会包含@EnableEurekaClient，所以其实@EnableEurekaClient不需要写
 */
@SpringBootApplication
@EnableZuulProxy  //支持网关路由
@EnableDiscoveryClient
public class GatewayZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayZuulApplication.class, args);
    }
}
