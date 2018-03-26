package com.andi.nms.redis;

import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {
    /**接收消息的方法*/
    public void handleMessage(String message,String topic){
        System.out.println("recived topic:"+topic+" message:"+message);
    }
}
