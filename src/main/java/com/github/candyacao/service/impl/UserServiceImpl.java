package com.github.candyacao.service.impl;

import com.github.candyacao.entity.UserEntity;
import com.github.candyacao.mapper.UserMapper;
import com.github.candyacao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserEntity signin(Long id) {
        return userMapper.getOne(id);
    }
}
