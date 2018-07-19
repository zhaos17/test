package com.zhaos.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 回文判断
 *
 * @author zhaos
 * @date 2018-07-17
 */
public class Palindrome {
    public static void main(String[] args) {
//        System.out.println(firstMethod("asdfghjk"));
//        System.out.println(thirdLongestPalindrome("abcbcddbc"));
        System.out.println(thirdLongestPalindrome("cabccbada"));
    }

    /**
     * 1.思想：
     *
     *     1）从最长的子串开始，遍历所有该原字符串的子串；
     *
     *     2）每找出一个字符串，就判断该字符串是否为回文；
     *
     *     3）子串为回文时，则找到了最长的回文子串，因此结束；反之，则继续遍历。
     *
     * 2.时间复杂度解释：
     *
     *     遍历字符串子串：嵌套一个循环、O(n^2)；
     *
     *     判断是否为回文：再次嵌套一个循环、O(n^3)。
     *
     * @param s
     * @return
     */
    public static String firstMethod (String s) {
        if(s.length() <= 1) {
            return s;
        }
        for(int i = s.length();i > 0; i--) {//子串长度
            for (int j = 0; j <= s.length() - i; j++) {
                String sub = s.substring(j , i + j);//子串位置
                int count = 0;//计数，用来判断是否对称
                for (int k = 0; k < sub.length() / 2; k++) {//左右对称判断
                    if (sub.charAt(k) == sub.charAt(sub.length() - k - 1))
                        count++;
                }
                if (count == sub.length() / 2) {
                    return sub;
                }
            }
        }
        return "";//表示字符串中无回文子串
    }


    /**
     * 这块是已经理解的代码
     */
    private static int maxLen = 0;

    private static String sub = "";

    public static String longestPalindrome(String s) {
        if(s.length() <= 1)
            return s;

        for(int i = 0;i < s.length()-1;i++){

            findLongestPalindrome(s,i,i);//单核回文
            findLongestPalindrome(s,i,i+1);//双核回文
        }
        return sub;
    }
    public static  void findLongestPalindrome(String s,int low,int high){
        while (low >= 0 && high <= s.length()-1){
            if(s.charAt(low) == s.charAt(high)){
                if(high - low + 1 > maxLen){
                    maxLen = high - low + 1;
                    sub = s.substring(low , high+1);
                }
                low --;//向两边扩散找当前字符为中心的最大回文子串
                high ++;
            }
            else
                break;
        }

    }


    /**
     * O(n)时间复杂度方法——Manacher算法
     *
     * @param s
     * @return
     */
    public static String thirdLongestPalindrome(String s) {
        List<Character> s_new = new ArrayList<>();
        for(int i = 0;i < s.length();i++){
            s_new.add('#');
            s_new.add(s.charAt(i));
        }
        s_new.add('#');
        List<Integer> Len = new ArrayList<>();
        String sub = "";//最长回文子串
        int sub_midd = 0;//表示在i之前所得到的Len数组中的最大值所在位置
        int sub_side = 0;//表示以sub_midd为中心的最长回文子串的最右端在S_new中的位置
        Len.add(1);
        for(int i = 1;i < s_new.size();i++){
            if(i < sub_side) {//i < sub_side时，在Len[j]和sub_side - i中取最小值，省去了j的判断
                int j = 2 * sub_midd - i;
                if(j >= 2 * sub_midd - sub_side &&  Len.get(j) <= sub_side - i){
                    Len.add(Len.get(j));
                }
                else
                    Len.add(sub_side - i + 1);
            }
            else//i >= sub_side时，从头开始匹配
                Len.add(1);
            while( (i - Len.get(i) >= 0 && i + Len.get(i) < s_new.size()) && (s_new.get(i - Len.get(i)) == s_new.get(i + Len.get(i))))
                Len.set(i,Len.get(i) + 1);//s_new[i]两端开始扩展匹配，直到匹配失败时停止
            if(Len.get(i) >= Len.get(sub_midd)){//匹配的新回文子串长度大于原有的长度
                sub_side = Len.get(i) + i - 1;
                sub_midd = i;
            }
        }
        sub = s.substring((2*sub_midd - sub_side)/2,sub_side /2);//在s中找到最长回文子串的位置
        return sub;

    }

}
