package com.tempName.service;

import com.tempName.entity.User;
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
    int create(User user);
    User retrieve(Integer id);
    int update(User user);
    int delete(Integer id);

    List<User> listAll();

    User selectByUserName(String username);

    String login(UserLoginParam loginParam);

    String register(User user);
}
