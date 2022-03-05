package mytest.reflect.chain;

import mytest.reflect.chain.Inteceptor.*;
import mytest.reflect.chain.Invocation.CglibMethodInvocation;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @description：
 * @author: whm
 * @create: 2022-03-03 11:13
 * @version：
 **/
public class MainClass {
    public static void main(String[] args) throws Throwable {
        //初始化拦截器
        List<MethodInteceptor> inteceptors = new ArrayList<>(4);
        inteceptors.add(new AspectJAfterThrowingAdvice());
        inteceptors.add(new AfterReturningAdviceInterceptor());
        inteceptors.add(new AspectJAfterAdvice());
        inteceptors.add(new MethodBeforeAdviceInterceptor());

        //利用反射获取目标类以及目标方法，然后初始化参数
        TargetClass targetClass = new TargetClass();
        Method method = targetClass.getClass().getMethod("targetMethod",String.class);
        Object[] methodArgs = {"我是参数"};

        //执行职责链
        CglibMethodInvocation methodInvocation = new CglibMethodInvocation(inteceptors,targetClass,method,methodArgs);
        methodInvocation.proceed();
    }
}