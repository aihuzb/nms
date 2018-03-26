package com.andi.nms.config;

import com.andi.nms.bean.User;
import com.andi.nms.redis.MessageReceiver;
import com.andi.nms.redis.RedisObjectSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.StringRedisSerializer;


@Configuration
public class RedisConfig {

    @Value("${subscribe.redis.topics}")
    private String topics;//当前激活的配置文件

    @Bean
    public RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,MessageListenerAdapter listenerAdapter) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        //订阅了一个叫chat 的通道
        String[] topicArray = topics.split(",");
        if(null != topicArray && topicArray.length > 0){
            for (String topic : topicArray) {
                container.addMessageListener(listenerAdapter, new PatternTopic(topic));
            }
        }
        //这个container 可以添加多个 messageListener
        return container;
    }
    @Bean
    MessageListenerAdapter listenerAdapter(MessageReceiver receiver) {
        //这个地方 是给messageListenerAdapter 传入一个消息接受的处理器，利用反射的方法调用“receiveMessage”
        //也有好几个重载方法，这边默认调用处理器的方法 叫handleMessage 可以自己到源码里面看
        return new MessageListenerAdapter(receiver);
    }

    @Bean
    public RedisTemplate<String, User> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, User> template = new RedisTemplate<String, User>();
        template.setConnectionFactory(factory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new RedisObjectSerializer());
        return template;
    }


}