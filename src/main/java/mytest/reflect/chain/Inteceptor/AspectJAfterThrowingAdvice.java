package mytest.reflect.chain.Inteceptor;

import mytest.reflect.chain.Inteceptor.MethodInteceptor;
import mytest.reflect.chain.Invocation.MethodInvocation;

/**
 * @description：
 * @author: whm
 * @create: 2022-03-03 11:13
 * @version：
 **/
public class AspectJAfterThrowingAdvice implements MethodInteceptor {
    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        try{
            return mi.proceed();
        }catch (Throwable throwable){
            System.out.println("假装执行了切面类@AfterThrowing标注的方法");
            throw throwable;
        }
    }
}