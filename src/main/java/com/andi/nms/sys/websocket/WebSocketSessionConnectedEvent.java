package com.andi.nms.sys.websocket;

import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.web.socket.messaging.SessionConnectedEvent;

public class WebSocketSessionConnectedEvent implements ApplicationListener<SessionConnectedEvent> {

    @Override
    public void onApplicationEvent(SessionConnectedEvent event) {
        StompHeaderAccessor headers = StompHeaderAccessor.wrap(event.getMessage()); //获取消息头
        String name = headers.getUser().getName(); //获取账号名
        System.out.println("onApplicationEvent===== >"+name);

    }
}
