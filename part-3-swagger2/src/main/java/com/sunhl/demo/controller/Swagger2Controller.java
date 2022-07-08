package com.sunhl.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: sunhailong
 * @Date: 2022/7/7 16:25
 * @Desc: swagger2的测试controller
 */
@Api(value = "swagger2-test")
@RestController
@RequestMapping("/api/part-3")
public class Swagger2Controller {

    private static final Logger log = LoggerFactory.getLogger(Swagger2Controller.class);

    @ApiOperation(value = "firstApi")
    @GetMapping(value = "/firstApi")
    @ResponseBody
    public String firstApi() {

        log.trace("this is trace");
        log.debug("this is debug");
        log.info("this is info");
        log.warn("this is warn");
        log.error("this is error");

        return "this is the first api for swagger2!";
    }

}
