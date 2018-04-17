package com.andi.nms.business.service.impl;

import com.andi.nms.business.dao.EntityMapper;
import com.andi.nms.business.bean.Entity;
import com.andi.nms.business.service.EntityService;
import com.andi.nms.sys.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/04/12.
 */
@Service
@Transactional
public class EntityServiceImpl extends AbstractService<Entity> implements EntityService {
    @Resource
    private EntityMapper tEntityMapper;

}
