package com.pong.service.impl;

import com.pong.mapper.UserMapper;
import com.pong.pojo.User;
import com.pong.pojo.UserExample;
import com.pong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User getUserById(Integer id) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andIdEqualTo(id);

        List<User> userList = userMapper.selectByExample(userExample);

        if (userList != null) {
            return userList.get(0);
        }
        return null;
    }
}
