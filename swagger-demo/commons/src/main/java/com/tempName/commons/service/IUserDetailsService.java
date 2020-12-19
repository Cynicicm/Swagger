package com.tempName.commons.service;

import com.tempName.commons.common.entity.User;

/**
 * Description:
 *
 * @author wenjie
 * @date Create on 2020/12/17
 */
public interface IUserDetailsService {
    User selectByUsername(String username);
}
