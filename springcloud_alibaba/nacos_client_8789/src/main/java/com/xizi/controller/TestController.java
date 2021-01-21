package com.xizi.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.StringTokenizer;

@RestController
@Slf4j
public class TestController {

    @GetMapping("/test/test")
    public String test(){
        log.info("进入test服务！！！");
        return "test服务调用成功！！！";
    }

    @GetMapping("/sentinel/test1")
    @SentinelResource(value = "aa",blockHandler = "fallBack",fallback = "fall")
    public String test1(int id){
        log.info("sentinel test1");
        if(id<0){
            throw new RuntimeException("非法参数!!!");
        }
        return "sentinel test1 :"+id;
    }



    //降级异常处理
    //相同的参数
    public String fallBack(int id, BlockException e){
        if(e instanceof FlowException){
            return "当前服务已被流控! "+e.getClass().getCanonicalName();
        }
        return "当前服务已被降级处理! "+e.getClass().getCanonicalName();
    }
    //异常处理
    //相同的参数
    public String fall(int id){
        return "当前服务已不可用!";
    }


}
