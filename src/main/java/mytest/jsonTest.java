package mytest;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-07-19 10:27
 **/
public class jsonTest {
    public static void main(String[] args) {
        JSONObject obj = new JSONObject();
        obj.put("key1", "value1");
        obj.put("key2", "value2");
        obj.put("key3", "value3");
        Map<String, String> map = JSONObject.parseObject(obj.toJSONString(), new TypeReference<Map<String, String>>() {
        });
        map.forEach((k,v) -> System.out.println(k+"  "+v));
//        Map<String, Object> hashMap = JSONObject.toJavaObject(obj,Map.class);
//        hashMap.forEach((k,v) -> System.out.println(k+"  "+v));
    }
}
