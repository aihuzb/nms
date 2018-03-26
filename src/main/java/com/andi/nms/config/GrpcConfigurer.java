package com.andi.nms.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GrpcConfigurer {
    @Value("nsm.rpc.server.port")
    private int serverPort;
    @Value("nsm.rpc.client.port")
    private int clientPort;



}
