package com.andi.nms.business;

import com.andi.nms.business.bean.User;
import com.andi.nms.business.service.UserService;
import com.andi.nms.business.web.LoginController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ComponentScan(basePackages = {"com.andi.nms.*"})
public class ServiceTest {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;


    @Test
    public  void testFindRoles(){
        Set<String> roles = userService.findRoles("operator");
        for(String role : roles){
            logger.warn("==========role=========== >"+role);
        }
    }

    @Test
    public void testFindByUserName(){
        User user = userService.findByUserName("admin");
        if(null != user){
            logger.warn("==========user=========== >"+user.toString());
        }
    }

    @Test
    public void testFindPermissions(){
        Set<String> admins = userService.findPermissions("admin");
        if(null != admins){
            for(String admin : admins){
                logger.warn("==========permission=========== >"+admin);
            }
        }
    }

}
