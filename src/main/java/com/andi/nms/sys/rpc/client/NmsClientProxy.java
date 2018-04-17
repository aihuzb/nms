package com.andi.nms.sys.rpc.client;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import java.lang.reflect.Method;

/**
 */

public class NmsClientProxy implements MethodInterceptor {
  @Override
  public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
    Object ret = methodProxy.invokeSuper(o,args);
    return ret;
  }

}
