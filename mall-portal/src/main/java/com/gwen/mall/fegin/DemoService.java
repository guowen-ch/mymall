package com.gwen.mall.fegin;

import com.gwen.mall.fegin.impl.DemoServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Description：
 * Created with IntelliJ IDEA
 * Created By guowen
 * Date: 2020/3/28
 * Time: 20:49
 */
// value=调用服务名字
// fallback 不能使用fallbackFactory
@FeignClient(value = "mall-admin",fallback = DemoServiceHystrix.class)
public interface DemoService {
    // 注意mall-admin模块的路径 server.servlet.context-path:/mall-admin
    @GetMapping("/mall-admin/sys/user/get")
    String getUser(@RequestParam("id") String id);
}
