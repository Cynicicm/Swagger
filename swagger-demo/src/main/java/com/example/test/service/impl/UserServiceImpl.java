package com.example.test.service.impl;

import com.example.test.entity.User;
import com.example.test.mapper.UserMapper;
import com.example.test.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.plaf.synth.SynthEditorPaneUI;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wenjie
 * @since 2020-09-26
 */
@Service
//@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public String getName(String id) {
        try{
            User user = userMapper.selectById(id);
//            user.setName("test");
//            userMapper.updateById(user);
            return user.getName();
        }catch (Exception e){
            return "failed";
        }
    }

    @Override
    public String logicDelete(String id) {
        try{
//            User user = userMapper.selectById(id);
//            user.setIsDeleted(1);
//            userMapper.updateById(user);
            userMapper.deleteById(id);
            return "success";
        }catch (Exception e){
            return "failed";
        }
    }

    @Override
    public int create(User user) {
        int result = userMapper.insert(user);
        return result;
    }

    @Override
    public User retrieve(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    public int update(User user) {
        User entity = userMapper.selectById(user.getId());
        BeanUtils.copyProperties(user,entity);
        int result = userMapper.updateById(entity);
        return result;
    }

    @Override
    public int delete(Integer id) {
        int result = userMapper.deleteById(id);
        return result;
    }
}
