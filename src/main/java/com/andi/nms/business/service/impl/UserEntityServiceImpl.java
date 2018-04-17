package com.andi.nms.business.service.impl;

import com.andi.nms.business.dao.UserEntityMapper;
import com.andi.nms.business.bean.UserEntity;
import com.andi.nms.business.service.UserEntityService;
import com.andi.nms.sys.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/04/12.
 */
@Service
@Transactional
public class UserEntityServiceImpl extends AbstractService<UserEntity> implements UserEntityService {
    @Resource
    private UserEntityMapper tUserEntityMapper;

}
