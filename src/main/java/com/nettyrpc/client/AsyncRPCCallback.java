package com.nettyrpc.client;

/**
 * Created by Created by houwenbo .
 */
public interface AsyncRPCCallback {

    void success(Object result);

    void fail(Exception e);

}
