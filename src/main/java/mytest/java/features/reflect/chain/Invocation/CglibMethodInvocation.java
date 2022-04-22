package mytest.java.features.reflect.chain.Invocation;

import mytest.java.features.reflect.chain.Inteceptor.MethodInteceptor;

import java.lang.reflect.Method;
import java.util.List;

/**
 * @description：
 * @author: whm
 * @create: 2022-03-03 11:09
 * @version：
 **/
public class CglibMethodInvocation implements MethodInvocation {

    List<MethodInteceptor> inteceptors;
    //当前拦截器链执行的位置。
    int currentInterceptorIndex = -1;

    //要切入的目标类对象，方法，方法参数
    Object target;
    Method method;
    Object[] args;

    public CglibMethodInvocation(List<MethodInteceptor> inteceptors, Object target, Method method, Object[] args) {
        this.inteceptors = inteceptors;
        this.target = target;
        this.method = method;
        this.args = args;
    }

    @Override
    public Object proceed() throws Throwable {
        //当拦截器链执行完之后，就执行目标类的目标方法。
        if (this.currentInterceptorIndex == this.inteceptors.size() - 1) {
            return method.invoke(target, args);
        }

        MethodInteceptor inteceptor = this.inteceptors.get(++currentInterceptorIndex);

        return inteceptor.invoke(this);
    }
}
