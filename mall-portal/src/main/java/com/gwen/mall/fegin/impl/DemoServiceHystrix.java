package com.gwen.mall.fegin.impl;

import com.gwen.mall.fegin.DemoService;
import org.springframework.stereotype.Component;

/**
 * Description：
 * Created By guowen
 */
@Component
public class DemoServiceHystrix implements DemoService {
    @Override
    public Object getUser(String id) {
        System.out.println("调用失败");
        return "调用失败";
    }
}
