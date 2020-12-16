package com.tempName.service;

import com.tempName.common.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tempName.common.request.UserLoginParam;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wenjie
 * @since 2020-09-26
 */
public interface IUserService extends IService<User> {
    User selectByUserName(String username);
    String login(UserLoginParam loginParam);
    String register(User user);
}
