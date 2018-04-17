package com.andi.nms.business.dao;

import com.andi.nms.business.bean.Role;
import com.andi.nms.sys.core.Mapper;

import java.util.List;

public interface RoleMapper extends Mapper<Role> {

    List<Role> findRolesByUserName(String userName);
}