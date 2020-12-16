package com.tempName.service.impl;

import com.tempName.entity.User;
import com.tempName.mapper.UserMapper;
import com.tempName.common.request.UserLoginParam;
import com.tempName.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tempName.common.utils.JwtTokenUtil;
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

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wenjie
 * @since 2020-09-26
 */
@Service
@MapperScan("com.tempName.mapper")
//@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public int create(User user) {
        return userMapper.insert(user);
    }

    @Override
    public User retrieve(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    public int update(User user) {
        User entity = userMapper.selectById(user.getId());
        BeanUtils.copyProperties(user,entity);
        return userMapper.updateById(entity);
    }

    @Override
    public int delete(Integer id) {
        return userMapper.deleteById(id);
    }

    @Override
    public List<User> listAll() {
        return userMapper.selectList(null);
    }

    @Override
    public User selectByUserName(String username) {
        return userMapper.selectByUsername(username);
    }

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
    public String register(User user) {
        User entity = new User();
        BeanUtils.copyProperties(user,entity);
        entity.setStatus(1);
        // 查询是否有相同用户名的用户
        User repeat = selectByUserName(entity.getUsername());
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
