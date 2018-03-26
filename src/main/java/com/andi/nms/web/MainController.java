package com.andi.nms.web;


import com.andi.nms.bean.User;
import com.andi.nms.core.ProjectConstant;
import com.andi.nms.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Controller
public class MainController {
    Logger logger = LoggerFactory.getLogger(MainController.class);
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private UserService userService;
    @Value("${session.time.out}")
    private int SESSION_TIME_OUT;
    @Autowired
    private RedisTemplate redisTemplate;
    @RequestMapping(value = "/")
    public String index(){
        return "/index";
    }

    @RequestMapping(value = "/login")
    public String login(HttpServletRequest request, HttpServletResponse response, User user){
        if(null != user && StringUtils.isNotEmpty(user.getUserName()) && StringUtils.isNotEmpty(user.getPassWord())){
            if(userService.checkUser(user)){
                String token = UUID.randomUUID().toString();
                stringRedisTemplate.opsForValue().set(token,user.getUserName());
                stringRedisTemplate.expire(token,SESSION_TIME_OUT, TimeUnit.SECONDS);
//          redisTemplate.opsForHash().put(token,user.getUserName());
                Cookie cookie = new Cookie(ProjectConstant.TOKEN_NAME,token);
                cookie.setMaxAge(SESSION_TIME_OUT*1000);
                cookie.setPath("/");
                response.addCookie(cookie);
                return "/pc/users";
            }
        }
        logger.info("login");
        return "/index";
    }

    @RequestMapping(value = "/users")
    public String users(HttpServletRequest request, HttpServletResponse response, User user){
        return "/pc/users";
    }

    @RequestMapping(value = "/enterprise")
    public String enterprise(HttpServletRequest request, HttpServletResponse response, User user){
        return "/pc/enterprise";
    }
}
