package com.zhaos.Test;

/**
 * @author zhaos
 * @date 2018-07-19
 */
public class Recursion {
    public static void main(String[] args) {
        System.out.println(cal(4));
    }

    /**
     * 计算i!的值
     *
     * @param i
     */
    public static int cal (int i) {
        if (i == 1) {
            return i;
        } else {
            return i*cal(i-1);
        }
    }
}
