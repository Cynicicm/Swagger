package com.tempName.user.mapper;

import com.tempName.commons.common.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wenjie
 * @since 2020-09-26
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    User selectByUsername(String username);
}
