package org.example.eleme.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.eleme.mapper.UserMapper;
import org.example.eleme.model.User;
import org.example.eleme.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> getAllUsers() {
        return baseMapper.getAll();
    }

    public User createUser(User user) {
        baseMapper.insert(user);
        return user;
    }

    public User getUserByPhone(String phone) {
        return baseMapper.selectOne(new QueryWrapper<User>().eq("phone", phone));
    }

    @Override
    public Long getUserIdByPhone(String phone) {
        return userMapper.selectUserIdByPhone(phone);
    }
}

