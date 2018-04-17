package com.andi.nms.business.service.impl;

import com.andi.nms.business.bean.Entity;
import com.andi.nms.business.bean.Role;
import com.andi.nms.business.bean.User;
import com.andi.nms.business.bean.UserEntity;
import com.andi.nms.business.dao.*;
import com.andi.nms.business.service.UserService;
import com.andi.nms.business.utils.BusinessUtil;
import com.andi.nms.sys.core.AbstractService;
import com.google.common.collect.Sets;
import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;


/**
 * Created by CodeGenerator on 2018/04/11.
 */
@Service
@Transactional
public class UserServiceImpl extends AbstractService<User> implements UserService {
    @Resource
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private UserEntityMapper userEntityMapper;

    @Autowired
    private EntityMapper entityMapper;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;



    @Override
    public Set<String> findPermissions(String username) {
        Set<String> pers = Sets.newHashSet();
        User user = findByUserName(username);
        if(null != user){
            List<UserEntity> userEntities =  userEntityMapper.findByUserId(user.getUserId());
            for(UserEntity userEntity : userEntities){
                Entity entity = entityMapper.selectByPrimaryKey(userEntity.getEntity());
                if(null != entity){
                    assemblePermissions(entity.getEntityKey(),userEntity.getAuthority(),pers);
                }
            }
        }
        return pers;
    }

    private void assemblePermissions(String entityKey, Integer authority, Set<String> pers) {
        List<String> authorityList = BusinessUtil.getAuthorityList(authority);
        if(CollectionUtils.isNotEmpty(authorityList)){
            for(String authorityStr : authorityList){
                pers.add(entityKey+":"+authorityStr);
            }
        }
    }

    @Override
    public User findByUserName(String userName) {
        return userMapper.findByUserName(userName);
    }

    @Override
    public List<String> findPermissionUrl(String userName) {
        return null;
    }

    @Override
    public boolean checkPermissionUrl(String userName, String curUrl) {
        return false;
    }

    @Override
    public Set<String> findRoles(String userName) {
        Set<String> roles = Sets.newHashSet();
        List<Role> roleList = roleMapper.findRolesByUserName(userName);
        if(CollectionUtils.isNotEmpty(roleList)){
            for(Role role : roleList){
                roles.add(role.getName());
            }
        }
        return roles;
    }

    @Override
    public void reciveMessage() {
        Subject currentUser = SecurityUtils.getSubject();
        String userName = (String) currentUser.getPrincipal();
        messagingTemplate.convertAndSendToUser(userName,"/alarm",new User(userName));
    }
}
