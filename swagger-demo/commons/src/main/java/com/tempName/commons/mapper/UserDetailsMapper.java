package com.tempName.commons.mapper;

import com.tempName.commons.common.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Description:
 *
 * @author wenjie
 * @date Create on 2020/12/17
 */
@Mapper
public interface UserDetailsMapper {
    User selectByUsername(String username);
}
