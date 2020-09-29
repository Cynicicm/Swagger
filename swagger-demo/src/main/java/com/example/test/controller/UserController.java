package com.example.test.controller;


import com.example.test.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wenjie
 * @since 2020-09-26
 */
@RestController
@Api(tags = "测试模块")
public class UserController {
    @Autowired
    private IUserService iUserService;

    @ApiOperation("获取姓名")
    @GetMapping("/name")
    public String getName(@RequestParam(value = "id",required = false)String id) {
        return iUserService.getName(id);
    }

    @ApiOperation("逻辑删除")
    @DeleteMapping("/name")
    public String logicDelete(@RequestParam(value = "id",required = false)String id) {
        return iUserService.logicDelete(id);
    }
}
