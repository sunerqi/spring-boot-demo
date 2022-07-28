package com.sunhl.demo.user.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: sunhailong
 * @Date: 2022/7/28 16:45
 * @Desc:
 */
@RestController
@Api("user api")
@RequestMapping("/api/part-5")
public class UserController {

    @ApiOperation("根据用户id获取用户信息")
    @RequestMapping(value = "/getUserById", method = RequestMethod.POST)
    @ResponseBody
    public String getUserById(@Param("用户id") @RequestParam(value = "id") int id){
        if (StringUtils.isEmpty(id)){
            return "参数为空！";
        }


        return null;
    }
}
