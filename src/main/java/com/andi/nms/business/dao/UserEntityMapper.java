package com.andi.nms.business.dao;

import com.andi.nms.business.bean.UserEntity;
import com.andi.nms.sys.core.Mapper;

import java.util.List;

public interface UserEntityMapper extends Mapper<UserEntity> {
    List<UserEntity> findByUserId(int userId);
}