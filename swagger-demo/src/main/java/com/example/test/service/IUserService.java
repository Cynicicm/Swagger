package com.example.test.service;

import com.example.test.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wenjie
 * @since 2020-09-26
 */
public interface IUserService extends IService<User> {
    String getName(String id);
    String logicDelete(String id);
}
