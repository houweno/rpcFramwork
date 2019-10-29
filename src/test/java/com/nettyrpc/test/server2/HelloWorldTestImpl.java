package com.nettyrpc.test.server2;

import com.nettyrpc.server.RpcService;
import com.nettyrpc.test.api.HelloWorldTest;


/**
 * Created by houwenbo
 */
@RpcService(HelloWorldTest.class)
public class HelloWorldTestImpl implements HelloWorldTest {

    @Override
    public String hellotest(String name) {
       return "hello"+name+",succeed ues rpc call service";
    }
    @Override
    public String loadbalanceTest(String name){
        return "call from server2";
    }
}
