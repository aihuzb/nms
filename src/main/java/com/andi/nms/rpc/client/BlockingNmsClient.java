/*
 * Copyright 2015, gRPC Authors All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.andi.nms.rpc.client;

import com.andi.nms.rpc.server.Ack;
import com.andi.nms.rpc.server.NmsServerGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A simple client that requests a greeting from the {@link NmsServerGrpc}.
 */
public class BlockingNmsClient implements NmsClient{
  private static final Logger logger = Logger.getLogger(BlockingNmsClient.class.getName());

  private final ManagedChannel channel;
  public final NmsClientGrpc.NmsClientBlockingStub blockingStub;

  /** Construct client connecting to HelloWorld server at {@code host:port}. */
  public BlockingNmsClient(String host, int port) {
    this(ManagedChannelBuilder.forAddress(host, port)
            // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
            // needing certificates.
            .usePlaintext(true)
            .build());
  }

  /** Construct client for accessing RouteGuide server using the existing channel. */
  BlockingNmsClient(ManagedChannel channel) {
    this.channel = channel;
    blockingStub = NmsClientGrpc.newBlockingStub(channel);
  }

  /** sendNetWork to server. */
  @Override
  public Ack sendNetWork(NetWork netWork) {
    logger.info("Will try to sendNetWork " + netWork + " ...");
    Ack ack = null;
    try {
      ack = blockingStub.sendNetWork(netWork);
    } catch (StatusRuntimeException e) {
      logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
      return ack;
    }
    logger.info("sendNetWork: " + ack.getMessage());
    return ack;
  }

  @Override
  public Ack sendDevice(Device device) {
    return blockingStub.sendDevice(device);
  }

  public void shutdown() throws InterruptedException {
    channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
  }


}
