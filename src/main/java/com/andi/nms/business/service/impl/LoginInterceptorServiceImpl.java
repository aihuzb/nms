package com.andi.nms.business.service.impl;

import com.andi.nms.business.bean.User;
import com.andi.nms.business.service.LoginInterceptorService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class LoginInterceptorServiceImpl implements LoginInterceptorService {
    private final Logger logger = LoggerFactory.getLogger(getClass());

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
