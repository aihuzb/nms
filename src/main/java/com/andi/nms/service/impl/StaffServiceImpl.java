package com.andi.nms.service.impl;

import com.andi.nms.dao.StaffMapper;
import com.andi.nms.bean.Staff;
import com.andi.nms.service.StaffService;
import com.andi.nms.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/02/10.
 */
@Service
@Transactional
public class StaffServiceImpl extends AbstractService<Staff> implements StaffService {
    @Resource
    private StaffMapper staffMapper;

}
