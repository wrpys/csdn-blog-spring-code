package com.wrpys.sb.service.impl;

import com.wrpys.sb.dao.UserRepository;
import com.wrpys.sb.model.User;
import com.wrpys.sb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wrp
 * @Date 2017/9/23
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
