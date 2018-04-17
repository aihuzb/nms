package com.andi.nms.business.dao;

import com.andi.nms.business.bean.User;
import com.andi.nms.sys.core.Mapper;

public interface UserMapper extends Mapper<User> {
    User findByUserName(String userName);
}