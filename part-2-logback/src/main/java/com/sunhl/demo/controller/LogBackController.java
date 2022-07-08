package com.sunhl.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: sunhailong
 * @Date: 2022/6/24 15:11
 * @Desc: logback日志实现
 */
@Api
@RestController
@RequestMapping("/api/part-2")
public class LogBackController {

    private static final Logger log = LoggerFactory.getLogger(LoggerFactory.class);


    @ApiOperation("日志")
    @GetMapping("/doLogBack")
    @ResponseBody
    public String doLogBack() {
        // log level: TRACE < DEBUG < INFO < WARN < ERROR

        log.trace("this is trace log: TRACE");
        log.debug("this is trace log: DEBUG");
        log.info("this is trace log: INFO");
        log.warn("this is trace log: WARN");
        log.error("this is trace log: ERROR");

        return "this is logback demo!";
    }
}
