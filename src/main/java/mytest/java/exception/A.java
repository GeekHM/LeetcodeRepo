package mytest.java.exception;

import org.junit.Test;

/**
 * @description：
 * @author: whm
 * @create: 2022-01-04 19:36
 * @version：
 **/
public class A {
    @Test
    public void test() {
        a();
    }

    public void a(){
        try {
            b();
        } catch (Exception e) {
            System.out.println("ssss");
//            throw e;
        } finally {
            System.out.println("aaaa");
        }
    }

    public void b() throws NullPointerException{
        try {
            c();
        } catch (Exception e) {
            throw e;
        }
    }

    public void c() {
        int i = 1 / 0;
    }
}
