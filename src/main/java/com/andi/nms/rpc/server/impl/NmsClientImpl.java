package com.andi.nms.rpc.server.impl;

import io.grpc.examples.client.NetWork;
import io.grpc.examples.client.NmsClientGrpc;
import io.grpc.examples.server.Ack;
import io.grpc.stub.StreamObserver;

public class NmsClientImpl extends NmsClientGrpc.NmsClientImplBase {


    @Override
    public void sendNetWork(NetWork netWork, StreamObserver<Ack> responseObserver) {
        Ack ack = Ack.newBuilder().setMessage("send network id: " +netWork.getId()+" alohaModel: "+ netWork.getAlohaModel() +" success!").build();
        responseObserver.onNext(ack);
        responseObserver.onCompleted();
    }
}
