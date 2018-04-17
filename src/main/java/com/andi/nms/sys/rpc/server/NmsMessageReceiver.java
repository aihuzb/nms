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

package com.andi.nms.sys.rpc.server;

import com.andi.nms.sys.rpc.server.handler.NmsMessageReceiverHandler;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Server that manages startup/shutdown of a {@code Greeter} server.
 */

public class NmsMessageReceiver {
  private final Logger logger = LoggerFactory.getLogger(getClass());

  private Server server;

  private int port = 60618;

  public NmsMessageReceiver(int port) {
    this.port = port;
  }


  private void init() throws IOException {
    /* The port on which the server should run */
    server = ServerBuilder.forPort(port)
        .addService(new NmsMessageReceiverHandler())
        .build()
        .start();
    logger.info("Server started, listening on " + port);
    Runtime.getRuntime().addShutdownHook(new Thread() {
      @Override
      public void run() {
        // Use stderr here since the logger may have been reset by its JVM shutdown hook.
        logger.info("*** shutting down gRPC server since JVM is shutting down");
        NmsMessageReceiver.this.stop();
        logger.info("*** server shut down");
      }
    });
  }

  private void stop() {
    if (server != null) {
      server.shutdown();
    }
  }

  /**
   * Await termination on the main thread since the grpc library uses daemon threads.
   */
  private void blockUntilShutdown() throws InterruptedException {
    if (server != null) {
      server.awaitTermination();
    }
  }

  /**
   * Main launches the server from the command line.
   */
  public static void main(String[] args) throws IOException, InterruptedException {
    final NmsMessageReceiver server = new NmsMessageReceiver(60618);
    server.init();
    server.blockUntilShutdown();
  }


}
