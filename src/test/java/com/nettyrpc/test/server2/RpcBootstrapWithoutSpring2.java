package com.nettyrpc.test.server2;

import com.nettyrpc.registry.ServiceRegistry;
import com.nettyrpc.server.RpcServer;
import com.nettyrpc.test.client.HelloService;
import com.nettyrpc.test.client.PersonService;
import com.nettyrpc.test.server.HelloServiceImpl;
import com.nettyrpc.test.server.RpcBootstrapWithoutSpring;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RpcBootstrapWithoutSpring2 {
    private static final Logger logger = LoggerFactory.getLogger(RpcBootstrapWithoutSpring.class);

    public static void main(String[] args) {
        String serverAddress = "127.0.0.1:18867";
        ServiceRegistry serviceRegistry = new ServiceRegistry("127.0.0.1:2181");
        RpcServer rpcServer = new RpcServer(serverAddress, serviceRegistry);
        PersonService PersonService = new PersonServiceImpl();
        rpcServer.addService("com.nettyrpc.test.client.PersonService", PersonService);
        try {
            rpcServer.start();
        } catch (Exception ex) {
            logger.error("Exception: {}", ex);
        }
    }
}
