package com.andi.nms.service.impl;

import com.andi.nms.dao.DepartmentMapper;
import com.andi.nms.bean.Department;
import com.andi.nms.service.DepartmentService;
import com.andi.nms.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/02/10.
 */
@Service
@Transactional
public class DepartmentServiceImpl extends AbstractService<Department> implements DepartmentService {
    @Resource
    private DepartmentMapper departmentMapper;

}
