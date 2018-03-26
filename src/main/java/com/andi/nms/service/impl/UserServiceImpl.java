package com.andi.nms.service.impl;

import com.andi.nms.dao.UserMapper;
import com.andi.nms.bean.User;
import com.andi.nms.service.UserService;
import com.andi.nms.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/02/10.
 */
@Service
@Transactional
public class UserServiceImpl extends AbstractService<User> implements UserService {
    @Resource
    private UserMapper userMapper;


    @Override
    public boolean checkUser(User user) {
        User dbUser = userMapper.selectOne(user);
        if(null != dbUser && user.getPassWord().equals(dbUser.getPassWord())){
            return true;
        }
        return false;
    }
}
