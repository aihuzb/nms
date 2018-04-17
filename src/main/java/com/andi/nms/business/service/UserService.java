package com.andi.nms.business.service;

import com.andi.nms.business.bean.User;
import com.andi.nms.sys.core.Service;

import java.util.List;
import java.util.Set;


/**
 * Created by CodeGenerator on 2018/04/11.
 */
public interface UserService extends Service<User> {

    Set<String> findPermissions(String username);

    User findByUserName(String userName);

    List<String> findPermissionUrl(String s);

    boolean checkPermissionUrl(String s, String curUrl);

    Set<String> findRoles(String username);

    void reciveMessage();
}
