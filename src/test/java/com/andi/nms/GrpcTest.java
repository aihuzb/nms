package com.andi.nms;

import com.andi.nms.sys.rpc.client.IpAddr;
import com.andi.nms.sys.rpc.client.NetWork;
import com.andi.nms.sys.rpc.client.NmsClientProxy;
import com.andi.nms.sys.rpc.client.NmsMessageSender;
import com.andi.nms.sys.rpc.client.utils.NmsMessageSenderFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ComponentScan(basePackages = {"com.andi.nms.*"})
public class GrpcTest {

    @Autowired
    NmsMessageSender nmsMessageSender;

    @Autowired
    NmsMessageSenderFactory factory;

    @Test
    public void client() throws Exception {
//        NmsMessageSender nmsMessageSender = factory.getInstance("127.0.0.1");
        nmsMessageSender.sendNetWork(NetWork.newBuilder().setId(1).setAlohaModel(3).setName("ncs").setNetWorkModel(8).setIpAddr(IpAddr.newBuilder().setIp(123).build()).build());
//        nmsMessageSender.shutdown();
    }

    @Test
    public void testTopic() throws Exception {
        NmsClientProxy nmsClientProxy = new NmsClientProxy();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(NmsMessageSender.class);
        enhancer.setCallback(nmsClientProxy);
        NmsMessageSender nmsClientHandler = (NmsMessageSender) enhancer.create();
        nmsClientHandler.sendNetWork(NetWork.newBuilder().setId(1).setAlohaModel(3).setName("ncs").setIpAddr(IpAddr.newBuilder().setIp(123).build()).build());
    }
}
