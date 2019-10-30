# rpcFramwork
zookeeper+netty+spring+protostuff实现的轻量级rpc框架。  
特点：  
1.可以实现寻找实现接口的服务端的地址，即服务端不用实现全部的接口，客户端会根绝调用的接口和方法寻找实现此接口的服务端的地址  
2.异步调用  
3.简洁易用高性能  
使用方法：  
	1.因为使用zookeeper作为治理中心，所以首先启动zookeeper,并在服务端配置zookeeper的地址  
	2.使用某种方式启动spring容器，例如用xml方式进行bean配置，见测试方法中的示例  
	3.客户端：  
		1.使用zookeeper服务地址创建ServiceDiscovery对象   
			ServiceDiscovery serviceDiscovery = new ServiceDiscovery("127.0.0.1:2181");  
		2.将ServiceDiscovery对象作为入参构造  
			RpcClient rpcClient = new RpcClient(serviceDiscovery);  
		3.根据请求的接口，构造要请求的IAsyncObjectProxy对象   
			IAsyncObjectProxy client = rpcClient.createAsync(HelloWorldTest.class);  
		4.异步调用，返回RPCFuture   
			RPCFuture helloPersonFuture = client.call("loadbalanceTest", "hwb");  
		5.添加RPCFuture对象处理函数  
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
