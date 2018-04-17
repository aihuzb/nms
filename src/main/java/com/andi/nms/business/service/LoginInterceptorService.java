package com.andi.nms.business.service;

import com.andi.nms.business.bean.User;

public interface LoginInterceptorService {

    public boolean checkToken(String token);

    public User checkUser(String token);
}
