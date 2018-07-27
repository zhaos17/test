package com.zhaos.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhaos
 * @date 2018-07-19
 */
public class FindArray {

    public static void main(String[] args) {
        Integer[] array = {1,2,3,4,5,6,2,3,2,2};
        find(array);
    }

    /**
     * 寻找数组中出现次数最多的数字并输出
     *
     * @param array
     */
    public static void find(Integer[] array) {
        List<Integer> list = Arrays.asList(array);
        int num = 0;
        int sumNum = 0;
        for (int i = 0; i < list.size(); i++) {
            int cal = list.get(i);
            int sum = 0;
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) == cal) {
                    sum++;
                }
            }
            if (sumNum < sum) {
                sumNum = sum;
                num = cal;
            }
        }
        System.out.println("出现次数最多的数字为："+num+",出现次数为："+sumNum);
    }

}
