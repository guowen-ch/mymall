package com.gwen.mall.fegin.impl;

import com.gwen.mall.fegin.DemoService;
import org.springframework.stereotype.Component;

/**
 * Description：
 * Created with IntelliJ IDEA
 * Created By guowen
 * Date: 2020/3/28
 * Time: 22:09
 */
@Component
public class DemoServiceHystrix implements DemoService {
    @Override
    public String getUser(String id) {
        System.out.println("调用失败");
        return "调用失败";
    }
}
