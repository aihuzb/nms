package com.andi.nms.business.web;


import com.andi.nms.business.bean.User;
import com.andi.nms.sys.shiro.UserRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
public class LoginController {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private UserRealm userRealm;

    @RequestMapping(value = {"loginPage"})
    public String loginPage(){
        logger.info("loginPage");
         return "loginPage";
    }


    @RequestMapping(value = {"index"})
    public String index(){
        logger.info("index");
        return "index";
    }

    @RequestMapping(value = {"reports"})
    @RequiresRoles("Operator")
    @RequiresPermissions("userList:view")
    public String reports(){
        Subject currentUser = SecurityUtils.getSubject();
        logger.info("reports session > "+currentUser.getSession().getId());
        logger.info("reports Principal > "+currentUser.getPrincipal().toString());
        PrincipalCollection principalCollection = currentUser.getPrincipals();
        logger.info("reports principalCollection > "+principalCollection);
        return "index";
    }


    @RequestMapping(value="login")
    public String login(HttpServletRequest request, HttpServletResponse response){
        String account = request.getParameter("userName");
        String password = request.getParameter("passWord");
        UsernamePasswordToken upt = new UsernamePasswordToken(account, password);
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.login(upt);
        logger.info("login");
        return "redirect:index";
    }

    @RequestMapping(value = "/users")
    public String users(HttpServletRequest request, HttpServletResponse response, User user){
        return "/pc/users";
    }

    @RequestMapping(value = "/enterprise")
    public String enterprise(HttpServletRequest request, HttpServletResponse response, User user){
        return "/pc/enterprise";
    }


    /**
     * Exit
     * @return
     */
    @RequestMapping("logout")
    public String logout() throws Exception {
        Subject subject = SecurityUtils.getSubject();
        userRealm.clearCached();
        userRealm.clearAllCached();
        subject.logout();
        return "redirect:index";
    }

    @RequestMapping(value = {"websocket"})
    public String websocket(){
        logger.info("websocket");
        return "websocket";
    }


    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public User greeting(SimpMessageHeaderAccessor simpMessageHeaderAccessor,User message) throws Exception {
        Thread.sleep(1000); // simulated delay

        Map<String, Object>  sessions = simpMessageHeaderAccessor.getSessionAttributes();
        for(String str : sessions.keySet()){
            logger.info("======sessions ====key > "+str+"   value "+ sessions.get(str));
        }

        return new User("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }



}
