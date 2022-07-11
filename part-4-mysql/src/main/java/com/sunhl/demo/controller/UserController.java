package com.sunhl.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: sunhailong
 * @Date: 2022/7/11 10:49
 * @Desc:
 */
@Api("MySQL-select-info")
@RestController
@RequestMapping("/api/part-4")
public class UserController {

    private final Logger log = LoggerFactory.getLogger(UserController.class);

    @ApiOperation("firstMysql")
    @GetMapping("/users")
    @ResponseBody
    public List<Map> firstMysql() {
        List<Map> list = new ArrayList<>();
        try {

            JDBCTest jdbcTest = new JDBCTest();
            String sql = "SELECT * FROM user";

            list = jdbcTest.connect(sql);
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return list;
    }

}
