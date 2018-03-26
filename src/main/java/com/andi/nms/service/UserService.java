package com.andi.nms.service;
import com.andi.nms.bean.User;
import com.andi.nms.core.Service;


/**
 * Created by CodeGenerator on 2018/02/10.
 */
public interface UserService extends Service<User> {

    public boolean checkUser(User user);
}
