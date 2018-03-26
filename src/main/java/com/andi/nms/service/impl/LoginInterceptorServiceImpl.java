package com.andi.nms.service.impl;

import com.andi.nms.bean.User;
import com.andi.nms.service.LoginInterceptorService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

@Service
public class LoginInterceptorServiceImpl implements LoginInterceptorService {
    Logger logger = LoggerFactory.getLogger(HandlerInterceptor.class);

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public boolean checkToken(String token) {
        return StringUtils.isNotEmpty(stringRedisTemplate.opsForValue().get(token));
    }

    @Override
    public User checkUser(String token) {
        User user= null;
        if(StringUtils.isNotEmpty(redisTemplate.opsForValue().get(token).toString())){
            user = (User) redisTemplate.opsForValue().get(token);
        }
        return user;
    }
}
