package com.andi.nms.business.service.impl;

import com.andi.nms.business.dao.RoleMapper;
import com.andi.nms.business.bean.Role;
import com.andi.nms.business.service.RoleService;
import com.andi.nms.sys.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/04/11.
 */
@Service
@Transactional
public class RoleServiceImpl extends AbstractService<Role> implements RoleService {
    @Resource
    private RoleMapper tRoleMapper;

}
