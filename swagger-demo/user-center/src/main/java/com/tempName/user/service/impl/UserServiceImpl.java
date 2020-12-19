package com.tempName.user.service.impl;

import com.tempName.commons.common.entity.User;
import com.tempName.commons.common.request.RegisterParam;
import com.tempName.commons.service.IUserDetailsService;
import com.tempName.user.mapper.UserMapper;
import com.tempName.commons.common.request.UserLoginParam;
import com.tempName.user.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tempName.commons.common.utils.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wenjie
 * @since 2020-09-26
 */
@Service
@MapperScan("com.tempName.user.mapper")
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private IUserDetailsService iUserDetailsService;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String login(UserLoginParam loginParam) {
        String token = null;
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(loginParam.getUsername());
            if (!passwordEncoder.matches(loginParam.getPassword(), userDetails.getPassword())) {
                throw new BadCredentialsException("密码不正确");
            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
        } catch (AuthenticationException e) {
            LOGGER.warn("登录异常:{}", e.getMessage());
        }
        return token;
    }

    @Override
    public String register(RegisterParam user) {
        User entity = new User();
//        log.info(entity.toString());
//        System.out.println(entity);
        BeanUtils.copyProperties(user,entity);
        entity.setStatus(1);
        // 查询是否有相同用户名的用户
        User repeat = iUserDetailsService.selectByUsername(entity.getUsername());
        if (repeat == null) {
            String encodePassword = passwordEncoder.encode(entity.getPassword());
            entity.setPassword(encodePassword);
            userMapper.insert(entity);
            return "success";
        }else {
            return "failed,repeat name";
        }
    }
}
