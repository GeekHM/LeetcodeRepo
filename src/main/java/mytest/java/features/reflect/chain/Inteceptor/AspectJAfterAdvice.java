package mytest.java.features.reflect.chain.Inteceptor;

import mytest.java.features.reflect.chain.Invocation.MethodInvocation;

/**
 * @description：
 * @author: whm
 * @create: 2022-03-03 11:12
 * @version：
 **/
public class AspectJAfterAdvice implements MethodInteceptor {
    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        try{
            return mi.proceed();
        }
        finally {
            System.out.println("假装这里执行了切面类@After标注的方法。。。。。。");
        }
    }
}