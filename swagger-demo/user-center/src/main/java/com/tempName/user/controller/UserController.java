package com.tempName.user.controller;


import com.tempName.commons.common.entity.User;
import com.tempName.commons.common.request.RegisterParam;
import com.tempName.commons.common.request.UserLoginParam;
import com.tempName.user.service.IUserService;
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

    @ApiOperation("Login")
    @PostMapping("/login")
    public String login(@RequestBody UserLoginParam userLoginParam) {
        return iUserService.login(userLoginParam);
    }

    @ApiOperation("Register")
    @PostMapping("/register")
    public String register(@RequestBody RegisterParam user) {
        return iUserService.register(user);
    }

}
