package com.andi.nms.business.service.impl;

import com.andi.nms.business.dao.UserRoleMapper;
import com.andi.nms.business.bean.UserRole;
import com.andi.nms.business.service.UserRoleService;
import com.andi.nms.sys.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/04/11.
 */
@Service
@Transactional
public class UserRoleServiceImpl extends AbstractService<UserRole> implements UserRoleService {
    @Resource
    private UserRoleMapper tUserRoleMapper;

}
