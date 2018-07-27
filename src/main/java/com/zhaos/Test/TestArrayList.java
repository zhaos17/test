package com.zhaos.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * ArrayList是线程不安全的，要使用线程安全的就使用Vector
 *
 * @author zhaos
 * @date 2018-07-27
 */
public class TestArrayList {

    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10 ;i++) {
            testList();
            list.clear();
        }
    }

    public static void testList() throws InterruptedException {
        Runnable runnable = () -> {
            for (int i = 1; i < 10000; i++) {
                list.add(i);
            }
        };

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        Thread t3 = new Thread(runnable);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println(list.size());
    }
}
