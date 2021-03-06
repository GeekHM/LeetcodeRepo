package mytest.MyThread;

import com.sun.jmx.snmp.tasks.ThreadService;

import java.util.concurrent.*;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-09-22 16:14
 **/
public class FutureTest {
    public int getDataA() throws InterruptedException {
        Thread.sleep(3000);
        return 1;
    }

    public int getDataB() throws InterruptedException {
        Thread.sleep(3000);
        return 8;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTest futureTest = new FutureTest();
        ExecutorService threadPoolExecutor = new ThreadPoolExecutor(
                8,
                14,
                30000, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(10),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        Future<Integer> futureA = threadPoolExecutor.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return futureTest.getDataA();
            }
        });
        Future<Integer> futureB = threadPoolExecutor.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return futureTest.getDataB();
            }
        });
        System.out.println("-----------结果计算中-----------");
        System.out.println("futureA:" + futureA.get());
        System.out.println("futureB:" + futureB.get());
        System.out.println(futureA.get()+futureB.get());
        threadPoolExecutor.shutdown();
    }
}


