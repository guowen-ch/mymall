package com.gwen.mall.fegin;

import com.gwen.mall.fegin.impl.DemoServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Description：
 * Created By guowen
 */
// value=调用服务名字
// fallback 不能使用fallbackFactory
@FeignClient(value = "mall-admin",fallback = DemoServiceHystrix.class)
public interface DemoService {
    // 注意mall-admin模块的路径 server.servlet.context-path:/mall-admin
    //当参数没有被 @RequestParam 注解修饰时，会自动被当做 request body 来处理。只要有 body，就会被 Feign 认为是 POST 请求.考虑版本
    @GetMapping("/mall-admin/sys/user/get")
    Object getUser(@RequestParam("id") String id);
}
