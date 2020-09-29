package com.example.test.mapper;

import com.example.test.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.mapstruct.Mapper;

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

}
