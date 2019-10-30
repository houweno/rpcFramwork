package com.nettyrpc.test.client;

import com.nettyrpc.client.AsyncRPCCallback;
import com.nettyrpc.client.RPCFuture;
import com.nettyrpc.client.RpcClient;
import com.nettyrpc.client.proxy.IAsyncObjectProxy;
import com.nettyrpc.registry.ServiceDiscovery;
import com.nettyrpc.test.api.HelloWorldTest;

import java.util.concurrent.CountDownLatch;

public class HelloWorldClientTest {
    public static void main(String[] args) {
        ServiceDiscovery serviceDiscovery = new ServiceDiscovery("127.0.0.1:2181");
        final RpcClient rpcClient = new RpcClient(serviceDiscovery);
        final CountDownLatch countDownLatch = new CountDownLatch(1);

        try {
            for(int i=0;i<5;i++) {
                IAsyncObjectProxy client = rpcClient.createAsync(HelloWorldTest.class);
                int num = 5;
                RPCFuture helloPersonFuture = client.call("loadbalanceTest", "hwb");
                helloPersonFuture.addCallback(new AsyncRPCCallback() {
                    @Override
                    public void success(Object result) {
                        System.out.println(result.toString());
                        countDownLatch.countDown();
                    }

                    @Override
                    public void fail(Exception e) {
                        System.out.println(e);
                        countDownLatch.countDown();
                    }
                });
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        rpcClient.stop();

        System.out.println("End");
    }
}
