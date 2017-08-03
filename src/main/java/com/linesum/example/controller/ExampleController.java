package com.linesum.example.controller;

import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试
 * @author wdongsen@linesum.com
 * @data 2017-06-20 11:32
 */
@RestController
@Api("测试相关api")
public class ExampleController {

    @ApiOperation("获取测试controller信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "username", dataType = "String", required = true, value = "用户的姓名"),
            @ApiImplicitParam(paramType = "query", name = "password", dataType = "String", required = false, value = "用户的密码")
    })
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数没填好"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")
    })
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String home(@RequestParam(required = true) String username, String password) {
        return "Hello world";
    }

}
