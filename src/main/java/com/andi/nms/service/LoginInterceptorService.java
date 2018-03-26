package com.andi.nms.service;

import com.andi.nms.bean.User;
import org.springframework.stereotype.Service;

public interface LoginInterceptorService {

    public boolean checkToken(String token);

    public User checkUser(String token);
}
