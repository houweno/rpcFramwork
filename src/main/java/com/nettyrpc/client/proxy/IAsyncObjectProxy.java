package com.nettyrpc.client.proxy;

import com.nettyrpc.client.RPCFuture;

/**
 * Created by houwenbo .
 */
public interface IAsyncObjectProxy {
    public RPCFuture call(String funcName, Object... args);
}