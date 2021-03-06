package com.nettyrpc.test.server;

import com.nettyrpc.server.RpcService;
import com.nettyrpc.test.api.HelloWorldTest;

@RpcService(HelloWorldTest.class)
public class HelloServiceImpl implements HelloWorldTest {

    @Override
    public String hellotest(String name) {
        return "Hello! " + name;
    }

    @Override
    public String loadbalanceTest(String name){
        return "call from server1";
    }
}
