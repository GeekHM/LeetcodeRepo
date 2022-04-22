package mytest.thread.basic;

import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * @description：
 * @author: whm
 * @create: 2022-01-26 13:42
 * @version：
 **/
public class ThreadLocalTest {
    //threadLocal使用方法
    public static final ThreadLocal<DateFormat> threadLocal = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));

    //线程之间共享threadLocal的方式
    @Test
    public void test() {
        final ThreadLocal threadLocal = new InheritableThreadLocal();
        threadLocal.set("帅得一匹");
        Object o = threadLocal.get();
        Thread t = new Thread() {
            @Override
            public void run() {
                super.run();
                System.out.println(threadLocal.get());
                System.out.println(o);
            }
        };
        t.start();
    }
}
