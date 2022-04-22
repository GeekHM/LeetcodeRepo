package mytest.java.features.reflect.chain.Inteceptor;

import mytest.java.features.reflect.chain.Invocation.MethodInvocation;

/**
 * @description：
 * @author: whm
 * @create: 2022-03-03 11:10
 * @version：
 **/
public interface MethodInteceptor {
    Object invoke(MethodInvocation mi) throws Throwable;
}
