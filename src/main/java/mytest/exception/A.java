package mytest.exception;

import org.junit.Test;

/**
 * @description：
 * @author: whm
 * @create: 2022-01-04 19:36
 * @version：
 **/
public class A {
    @Test
    public void test(){
        a();
    }

    public void a() {
        b();
    }

    public void b(){
        c();
    }

    public void c(){
       int i = 1/0;
    }
}
