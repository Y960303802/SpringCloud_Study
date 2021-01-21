package com.xizi.fallback;


import com.xizi.client.ProductClient;
import com.xizi.pojo.Product;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Component
public class ProductClientFallBack implements ProductClient {

    @Override
    public String showMessage() {
        return "当前服务已被降级！！";
    }

    @Override
    public Map<String, Object> findAll() {
        Map map=new HashMap<String,Object>();
        map.put("status", false);
        map.put("msg","当前查询所有信息服务不可用,服务已被降级！！！");
        return map;
    }

    @Override
    public Map<String, Object> findOne(String productId) {

        Map map=new HashMap<String,Object>();

        map.put("status", false);
        map.put("msg","当前查询信息服务不可用,服务已被降级！！！");
        return map;
    }

    @Override
    public Map<String, Object> save(String name) {
        Map map=new HashMap<String,Object>();

        map.put("status", false);
        map.put("msg","当前保存信息服务不可用,服务已被降级！！！");
        return map;
    }

    @Override
    public Map<String, Object> update(Product product) {
        Map map=new HashMap<String,Object>();

        map.put("status", false);
        map.put("msg","当前更新信息服务不可用,服务已被降级！！！");
        return map;
    }
}
