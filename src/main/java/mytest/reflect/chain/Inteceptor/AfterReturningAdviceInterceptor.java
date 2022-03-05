package mytest.reflect.chain.Inteceptor;

import mytest.reflect.chain.Inteceptor.MethodInteceptor;
import mytest.reflect.chain.Invocation.MethodInvocation;

/**
 * @description：
 * @author: whm
 * @create: 2022-03-03 11:13
 * @version：
 **/
public class AfterReturningAdviceInterceptor implements MethodInteceptor {
    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        Object returnVal = mi.proceed();
        System.out.println("假装这里执行了切面类@AfterReturning标注的方法。。。。。。");
        return returnVal;
    }
}
