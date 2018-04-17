package com.andi.nms.sys.config;

import com.andi.nms.sys.websocket.WebSocketHandshakeInterceptor;
import com.andi.nms.sys.websocket.WebSocketSessionConnectedEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Value("${nms.websocket.base.url}")
    private String endpoint;
    @Value("${nms.websocket.prefixes.url}")
    private String prefixes;
    @Value("${nms.websocket.broker.url}")
    private String broker;
    @Value("${nms.websocket.app.prefixes}")
    private String appUrl;


    @Bean
    public WebSocketSessionConnectedEvent webSocketSessionConnectedEvent(){
        return new WebSocketSessionConnectedEvent();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        String[] topics = broker.split(",");
        System.out.println(topics[0]);
        config.enableSimpleBroker(topics);
        //定义一对一推送的时候前缀
        config.setUserDestinationPrefix(prefixes);
        config.setApplicationDestinationPrefixes(appUrl);
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint(endpoint)
                .setAllowedOrigins("*")
                .addInterceptors(new HttpSessionHandshakeInterceptor())//绑定http_session到websocket会话
                .addInterceptors(new WebSocketHandshakeInterceptor())//websoket会话握手处理类实现
                .withSockJS();
    }


}
