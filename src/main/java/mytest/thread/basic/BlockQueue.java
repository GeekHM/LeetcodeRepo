package mytest.thread.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-10-02 00:31
 **/
public class BlockQueue {
    public static void main(String[] args) {
        ArrayBlockingQueue<List> arrayBlockingQueue = new ArrayBlockingQueue(10);
        List<String> list = new ArrayList<>(20);
        List<String> list1 = new ArrayList<>(0);
        arrayBlockingQueue.add(list);
        arrayBlockingQueue.add(list1);
        for (List l : arrayBlockingQueue) {
            if(l.size() <= 0){
                System.out.println("用size做标记吧");
            }
        }
    }
}
