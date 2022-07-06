package com.sunhl.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.yaml.snakeyaml.constructor.BaseConstructor;

/**
 * @Author: sunhailong
 * @Date: 2022/6/23 15:21
 * @Desc:
 */
@RestController
@RequestMapping("/api/part-1")
public class HelloController extends BaseConstructor {

    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/hello")
    @ResponseBody
    public String sayHello() {
        return "Hello Word!";
    }
}
