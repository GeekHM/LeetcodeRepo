package mytest.thread.basic;

import java.util.concurrent.*;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-09-22 16:30
 **/
public class FutureTest2 {
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
        FutureTask<Integer> futureA = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return futureTest.getDataA();
            }
        });
        FutureTask<Integer> futureB = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return futureTest.getDataB();
            }
        });
        threadPoolExecutor.submit(futureA);
        threadPoolExecutor.submit(futureB);
        System.out.println("-----------结果计算中-----------");
        System.out.println("futureA:" + futureA.get());
        System.out.println("futureB:" + futureB.get());
        System.out.println(futureA.get() + futureB.get());
        threadPoolExecutor.shutdown();
    }
}
