package com.example.demo.controller;


import com.example.demo.entity.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class HelloController {

    @RequestMapping(value = "/hello")
    public String sayHello(){
        return "index";
    }

    /**
     * 分页
     * @param params
     * @return
     */
    @RequestMapping("/page")
    public Page page(@RequestParam Map<String, Object> params){
        // PageHelper 使用非常简单，只需要设置页码和每页显示笔数即可
        int offset = Integer.parseInt( params.get("offset").toString());
        int limit = Integer.parseInt(params.get("limit").toString());
        int startPage = offset/limit + 1;
        PageHelper.startPage(startPage, limit);

        // 设置分页查询条件
        Example example = new Example(LedLight.class);
        PageInfo<LedLight> pageInfo = new PageInfo<>(ledLightMapper.selectByExample(example));

        // 获取查询结果
        List<LedLight> LedLights = pageInfo.getList();

        Page page = new Page();
        page.setTotal(pageInfo.getTotal());
        page.setRows(pageInfo.getList());


        return page;
    }

}
