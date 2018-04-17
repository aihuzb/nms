package com.andi.nms.sys.websocket;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.server.HandshakeInterceptor;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by huzhibin on 2017/8/3.
 */
public class WebSocketHandshakeInterceptor implements HandshakeInterceptor {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse serverHttpResponse, org.springframework.web.socket.WebSocketHandler webSocketHandler, Map<String, Object> map) throws Exception {
        if (request instanceof ServletServerHttpRequest) {
            ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
            servletRequest.getHeaders();
            HttpSession session = servletRequest.getServletRequest().getSession(false);
            if (session != null) {
                //这里可以合用不同的userName区分WebSocketHandler，也可以将用户分组或贴标签，以便定向发送消息
                //String userName = (String) session.getAttribute(Constants.SESSION_USERNAME);
                //这里是模拟测试，没有userName,用sessionId代为表示
                logger.info(session.getId());
                Subject currentUser = SecurityUtils.getSubject();
                logger.info("=======>"+currentUser.getPrincipal());
            }
        }
        return true;
    }

    @Override
    public void afterHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, org.springframework.web.socket.WebSocketHandler webSocketHandler, Exception e) {

    }
}
