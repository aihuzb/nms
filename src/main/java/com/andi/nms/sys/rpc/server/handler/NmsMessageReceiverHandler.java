package com.andi.nms.sys.rpc.server.handler;

import com.andi.nms.sys.rpc.client.NmsClientGrpc;
import com.andi.nms.sys.rpc.server.Ack;

public class NmsMessageReceiverHandler extends NmsClientGrpc.NmsClientImplBase{ //NmsServerGrpc.NmsServerImplBase {


//    @Override
//    public void syncDeviceState(DeviceState request,StreamObserver<Ack> responseObserver) {
//        //Do something for client request
//        System.out.println("recever datas > "+request);
//        //Reply client Ack
//        responseObserver.onNext(Ack.newBuilder().setCode(1).setMessage("success").build());
//    }

    @Override
    public void sendNetWork(com.andi.nms.sys.rpc.client.NetWork request,
                            io.grpc.stub.StreamObserver<com.andi.nms.sys.rpc.server.Ack> responseObserver) {
       // Do something for client request
        System.out.println("recever datas > "+request);
        //Reply client Ack
        responseObserver.onNext(Ack.newBuilder().setCode(1).setMessage("success").build());
    }


}
