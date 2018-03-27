package com.andi.nms.rpc.server.impl;

import com.andi.nms.rpc.client.NetWork;
import com.andi.nms.rpc.client.NmsClientGrpc;
import com.andi.nms.rpc.server.Ack;
import io.grpc.stub.StreamObserver;

public class NmsClientImpl extends NmsClientGrpc.NmsClientImplBase {


    @Override
    public void sendNetWork(NetWork netWork, StreamObserver<Ack> responseObserver) {
        Ack ack = Ack.newBuilder().setMessage("send network id: " +netWork.getId()+" alohaModel: "+ netWork.getAlohaModel() +" success!").build();
        responseObserver.onNext(ack);
        responseObserver.onCompleted();
    }
}
