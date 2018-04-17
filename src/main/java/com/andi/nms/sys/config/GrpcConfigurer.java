package com.andi.nms.sys.config;

import com.andi.nms.sys.rpc.client.NmsMessageSender;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GrpcConfigurer {

    @Value("${nms.rpc.connect.host}")
    private String connectHost;
    @Value("${nms.rpc.server.port}")
    private int serverPort;
    @Value("${nms.rpc.client.port}")
    private int clientPort;

//    @Bean(initMethod="init",destroyMethod="blockUntilShutdown")
//    public NmsMessageReceiver nmsMessageReceiver(){
//        return new NmsMessageReceiver(clientPort);
//    }

    @Bean(name = "messageSender",initMethod="init",destroyMethod="shutdown")
    public NmsMessageSender nmsMessageSender(){
        return new NmsMessageSender(connectHost,clientPort);
    }


}
