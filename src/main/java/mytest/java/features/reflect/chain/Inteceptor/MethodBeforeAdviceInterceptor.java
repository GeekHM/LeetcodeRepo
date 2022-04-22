package mytest.java.features.reflect.chain.Inteceptor;

import mytest.java.features.reflect.chain.Invocation.MethodInvocation;

/**
 * @description：
 * @author: whm
 * @create: 2022-03-03 11:12
 * @version：
 **/
public class MethodBeforeAdviceInterceptor implements MethodInteceptor {
    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        System.out.println("假装这里执行了切面类@Before标注的方法。。。。。。。");
        return mi.proceed();
    }
}
