package com.tempName.controller;


import com.tempName.entity.User;
import com.tempName.common.request.UserLoginParam;
import com.tempName.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @ApiOperation("Create")
    @PostMapping("/user")
    public int create(@RequestBody User user) {
        return iUserService.create(user);
    }

    @ApiOperation("Retrieve")
    @GetMapping("/user")
    public User retrieve(@RequestParam(value = "id") Integer id) {
        return iUserService.retrieve(id);
    }

    @ApiOperation("Update")
    @PutMapping("/user")
    public int update(@RequestBody User user) {
        return iUserService.update(user);
    }

    @ApiOperation("Delete")
    @DeleteMapping("/user")
    public int delete(@RequestParam(value = "id") Integer id) {
        return iUserService.delete(id);
    }

    @ApiOperation("ListAll")
    @GetMapping("/user/list")
    public List<User> retrieve() {
        return iUserService.listAll();
    }

    @ApiOperation("Login")
    @PostMapping("/login")
    public String login(@RequestBody UserLoginParam userLoginParam) {
        return iUserService.login(userLoginParam);
    }

    @ApiOperation("Register")
    @PostMapping("/register")
    public String register(@RequestBody User user) {
        return iUserService.register(user);
    }

}
