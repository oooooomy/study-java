package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class UnsafeMapExample {

    public static void main(String[] args) throws InterruptedException {
        ConcurrentMap<String, Integer> map = new ConcurrentHashMap<>();
        map.put("key", 0);

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                map.compute("key", (k, v) -> v + 1); // 原子操作
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                map.compute("key", (k, v) -> v + 1); // 原子操作
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Final value: " + map.get("key")); // 结果一定是2000
    }

}
