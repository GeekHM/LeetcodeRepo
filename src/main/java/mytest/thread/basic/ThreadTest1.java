package mytest.thread.basic;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-08-25 10:38
 **/
public class ThreadTest1 {
    public static void main(String[] args) throws InterruptedException {
        Mythread mythread = new Mythread();
        Thread thread = new Thread(mythread);
        thread.start();
        Thread.sleep(2000);
        mythread.call();
    }
}

class Mythread implements Runnable {
    private int v;

    @Override
    public void run() {
        try {
            test(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void call() throws InterruptedException {
        test(10);
    }

    public synchronized void test(int v) throws InterruptedException {
        this.v = v;
        System.out.println(Thread.currentThread().getName() + "      " + v);
        Thread.sleep(5000);
        System.out.println(Thread.currentThread().getName() + "      " + v);
    }

}
