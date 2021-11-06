package mytest;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-10-11 09:58
 **/
public class Singleton {
    private volatile static Singleton singleton;

    Singleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
    }

    public static Singleton getSingleton() {
        return singleton;
    }
}
