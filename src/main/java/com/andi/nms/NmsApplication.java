package com.andi.nms;

import com.andi.nms.rpc.client.BlockingNmsClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.andi.nms.*"})
public class NmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(NmsApplication.class, args);
		BlockingNmsClient blockingNmsClient = new BlockingNmsClient("",8080);
//		blockingNmsClient.blockingStub.sendNetWork();
	}
}
