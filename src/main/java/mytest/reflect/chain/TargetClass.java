package mytest.reflect.chain;

/**
 * @description：
 * @author: whm
 * @create: 2022-03-03 11:12
 * @version：
 **/
public class TargetClass {
    public void targetMethod(String s){
        //先简单抛个异常
        //int i = 1 / 0;
        System.out.println("假装这里执行了目标类的目标方法,传参："+s);
    }
}
