
package com.andi.nms.sys.rpc.client.utils;


import com.andi.nms.sys.rpc.client.NmsMessageSender;
import com.andi.nms.sys.utils.ApplicationContextUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/*
 *
 *
 * @describe
 * @author huzb
 * @date 2018/3/30 14:24
 */
@Component
public class NmsMessageSenderFactory {

    @Value("${nms.rpc.client.port}")
    private int port;

    public NmsMessageSender getInstanceBySpring(String host){
        synchronized(this) {//防止获取到目的ip不一致的消息发送者
            ApplicationContext context = ApplicationContextUtil.getApplicationContext();
            //获取BeanFactory
            DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) context.getAutowireCapableBeanFactory();
            //创建bean信息.
            BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(NmsMessageSender.class);
            beanDefinitionBuilder.addPropertyValue("host",host);
            beanDefinitionBuilder.addPropertyValue("port",port);
            //动态注册bean.
            defaultListableBeanFactory.registerBeanDefinition("messageSender", beanDefinitionBuilder.getBeanDefinition());
            //获取动态注册的bean.
            NmsMessageSender messageSender =context.getBean("messageSender",NmsMessageSender.class);
            messageSender.init();
            return messageSender;
        }
    }

    public NmsMessageSender getInstance(String host){
        synchronized(this) {//防止获取到目的ip不一致的消息发送者
            //获取动态注册的bean.
            NmsMessageSender messageSender =new NmsMessageSender(host,port);
            messageSender.init();
            return messageSender;
        }
    }

}
