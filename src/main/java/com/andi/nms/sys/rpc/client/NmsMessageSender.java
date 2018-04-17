package com.andi.nms.sys.rpc.client;

import com.andi.nms.sys.rpc.server.Ack;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nullable;
import java.util.concurrent.TimeUnit;


public class NmsMessageSender extends NmsClientGrpc.NmsClientImplBase{

    private final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * Construct client connecting to HelloWorld server at {@code host:port}.
     *
     * @param host
     */
    private String host;
    private int port;
    private  ManagedChannel channel;
    private  NmsClientGrpc.NmsClientBlockingStub blockingStub;//阻塞
    private  NmsClientGrpc.NmsClientFutureStub futureStub;//
    private  NmsClientGrpc.NmsClientStub asyncStub;//异步

    public NmsMessageSender() {

    }

    public NmsMessageSender(String host,int port) {
        this.host = host;
        this.port = port;
    }

    public  String getHost() {
        return host;
    }

    public  void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void init() {
        start(ManagedChannelBuilder.forAddress(host, port)
                // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
                // needing certificates.
                .usePlaintext(true)
                .build());
        logger.info("-------------NmsMessageSender init---------------");
    }

    public void start(ManagedChannel channel) {
        this.channel = channel;
        blockingStub = NmsClientGrpc.newBlockingStub(channel);
        futureStub = NmsClientGrpc.newFutureStub(channel);
        asyncStub = NmsClientGrpc.newStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(2, TimeUnit.SECONDS);
    }


    public Ack sendNetWork(NetWork netWork, int... type) throws Exception{
        logger.info("=======sendNetWork======="+netWork);
        Ack ack = blockingStub.sendNetWork(netWork);
        logger.info("=======sendNetWork ack======="+ack);
        return  ack;
    };


    public void sendNetWorkAsync(NetWork netWork, int... type) throws Exception{
        logger.info("=======sendNetWorkAsync======="+netWork);
        StreamObserver<Ack> streamObserver = new StreamObserver<Ack>() {
            @Override
            public void onNext(Ack ack) {
                logger.info("=======sendNetWorkAsync ack======="+ ack);
            }
            @Override
            public void onError(Throwable throwable) {
                logger.warn("=======sendNetWorkAsync error======="+throwable.getMessage());
            }

            @Override
            public void onCompleted() {
                logger.warn("=======sendNetWorkAsync vompleted=======");
            }
        };
        asyncStub.sendNetWork(netWork,streamObserver);
    };

    public void sendNetWorkFeature(NetWork netWork, int... type) throws Exception{
        ListenableFuture<Ack> listenableFuture = futureStub.sendNetWork(netWork);
        Futures.addCallback(listenableFuture, new FutureCallback<Ack>() {
            @Override
            public void onSuccess(@Nullable Ack ack) {
                logger.info("=======sendNetWorkFeature ack======="+ ack);
            }
            @Override
            public void onFailure(Throwable throwable) {
                logger.warn("=======sendNetWorkFeature error======="+throwable.getMessage());
            }
        }, MoreExecutors.directExecutor());
    }




}
