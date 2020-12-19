package com.tempName.commons.service.impl;

import com.tempName.commons.common.entity.User;
import com.tempName.commons.mapper.UserDetailsMapper;
import com.tempName.commons.service.IUserDetailsService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description:
 *
 * @author wenjie
 * @date Create on 2020/12/17
 */
@Service
@MapperScan("com.tempName.commons.mapper")
public class UserDetailsServiceImpl implements IUserDetailsService {

    @Autowired
    private UserDetailsMapper userDetailsMapper;

    @Override
    public User selectByUsername(String username) {
        return userDetailsMapper.selectByUsername(username);
    }
}
