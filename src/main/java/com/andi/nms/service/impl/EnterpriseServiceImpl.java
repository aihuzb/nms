package com.andi.nms.service.impl;

import com.andi.nms.dao.EnterpriseMapper;
import com.andi.nms.bean.Enterprise;
import com.andi.nms.service.EnterpriseService;
import com.andi.nms.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/02/10.
 */
@Service
@Transactional
public class EnterpriseServiceImpl extends AbstractService<Enterprise> implements EnterpriseService {
    @Resource
    private EnterpriseMapper enterpriseMapper;

}
