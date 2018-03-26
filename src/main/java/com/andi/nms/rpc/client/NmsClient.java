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

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.examples.client.NetWork;
import io.grpc.examples.client.NmsClientGrpc;
import io.grpc.examples.server.Ack;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A simple client that requests a greeting from the {@link io.grpc.examples.server.NmsServerGrpc}.
 */
public class NmsClient {
  private static final Logger logger = Logger.getLogger(NmsClient.class.getName());

  private final ManagedChannel channel;
  private final NmsClientGrpc.NmsClientBlockingStub blockingStub;

  /** Construct client connecting to HelloWorld server at {@code host:port}. */
  public NmsClient(String host, int port) {
    this(ManagedChannelBuilder.forAddress(host, port)
        // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
        // needing certificates.
        .usePlaintext(true)
        .build());
  }

  /** Construct client for accessing RouteGuide server using the existing channel. */
  NmsClient(ManagedChannel channel) {
    this.channel = channel;
    blockingStub = NmsClientGrpc.newBlockingStub(channel);
  }

  public void shutdown() throws InterruptedException {
    channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
  }

  /** Say hello to server. */
  public void sendNetWork(String name) {
    logger.info("Will try to greet " + name + " ...");
    NetWork netWork = NetWork.newBuilder().setAlohaModel(2).setId(11).build();
    Ack ack;
    try {
      ack = blockingStub.sendNetWork(netWork);
    } catch (StatusRuntimeException e) {
      logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
      return;
    }
    logger.info("Greeting: " + ack.getMessage());
  }

  /**
   * Greet server. If provided, the first element of {@code args} is the name to use in the
   * greeting.
   */
  public static void main(String[] args) throws Exception {
    NmsClient client = new NmsClient("localhost", 50051);
    try {
      /* Access a service running on the local machine on port 50051 */
      String user = "world";
      if (args.length > 0) {
        user = args[0]; /* Use the arg as the name to greet if provided */
      }
      client.sendNetWork(user);
    } finally {
      client.shutdown();
    }
  }
}
