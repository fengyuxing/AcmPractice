package com.practice.acm.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 解题思路
 * 1、从1遍历到M，判断每一个数是否是素数，然后累加。
 * 2、判断出来是素数，加到一个list中，注意1不能算。
 * 3、判断数字k是素数的方法是，遍历第二步中的list，一次取余，全部都不能能除尽则表示k是素数。
 * 4、第一步遍历完成后，找出list中大于N的数，进行累加
 */
public class Problem1 {
    static  List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int M = Math.max(a, b);
        int N = Math.min(a, b);
        //1
        for (int i = 2; i <= M; i++) {
            //2
            if (isSuShu(i)) {
                list.add(i);
            }
        }
        //4
        int total = 0;
        for (int j = 0; j < list.size(); j++) {
            if (list.get(j) > N) {
                total += list.get(j);
            }
        }
        System.out.println(total);
    }

    //3
    public static boolean isSuShu(int num) {
        for (int j = 0; j < list.size(); j++) {
            if (num%list.get(j)==0){
                return false;
            }
        }
        return  true;
    }
}