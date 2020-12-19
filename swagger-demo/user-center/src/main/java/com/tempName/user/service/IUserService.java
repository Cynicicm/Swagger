package com.tempName.user.service;

import com.tempName.commons.common.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tempName.commons.common.request.RegisterParam;
import com.tempName.commons.common.request.UserLoginParam;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wenjie
 * @since 2020-09-26
 */
public interface IUserService extends IService<User> {
    String login(UserLoginParam loginParam);
    String register(RegisterParam user);
}
