package com.example.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "用户数据接口")
public class UserController {
    @ApiOperation(value = "查询用户",notes = "根据id查询用户")
    @ApiImplicitParam(paramType = "path",name = "id",value = "用户id",required = true)
    @GetMapping(value = "/user/{id}")
    public String getUserById(@PathVariable Integer id){
        return "/user/"+id;
    }
}
