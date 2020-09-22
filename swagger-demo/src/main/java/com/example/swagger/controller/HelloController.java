package com.example.swagger.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @author wenjie
 * @date Create on 2020/9/22
 */
@RestController
public class HelloController {
    @RequestMapping(value="/hello")
    public String hello(){
        return "hello";
    }
}
