package com.andi.nms.sys.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by huzhibin on 2017/8/3.
 */
public class BaseWebSocketHandler extends TextWebSocketHandler {
    Logger log = LoggerFactory.getLogger(getClass());
    //已建立连接的用户
    private static final ArrayList<WebSocketSession> users = new ArrayList<WebSocketSession>();;


    /**
     * 处理前端发送的文本信息
     *
     * @param session
     * @param message
     * @throws Exception
     */
    @Override
    protected void handleTextMessage(WebSocketSession session,
                                     TextMessage message) throws Exception {
        // 获取提交过来的消息详情
        log.debug("-------handleMessage" + message.toString());
        //回复一条信息，
        session.sendMessage(new TextMessage("reply msg:" +message.getPayload()));

    }

    /**
     * 当新连接建立的时候，被调用;
     *
     * @param session
     * @throws Exception
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        log.info("Connection Established"+session);
        users.add(session);
//        session.sendMessage(new TextMessage("connect successful!"));
//        session.sendMessage(new TextMessage("new_msg"));
        super.afterConnectionEstablished(session);
    }

    /**
     * 当连接关闭时被调用；
     *
     * @param session
     * @param status
     * @throws Exception
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        log.info("Connection closed. Status: " + status);
        users.remove(session);
        super.afterConnectionClosed(session, status);
    }

    /**
     * 给所有在线用户发送消息
     *
     * @param message
     */
    public void sendMessageToUsers(TextMessage message) {
        for (WebSocketSession user : users) {
            try {
                if (user.isOpen()) {
                    user.sendMessage(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 给某个用户发送消息
     *
     * @param userName
     * @param message
     */
    public void sendMessageToUser(String userName, TextMessage message) {
        for (WebSocketSession user : users) {
            try {
                if (user.isOpen()) {
                    user.sendMessage(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            break;
        }
    }

}
