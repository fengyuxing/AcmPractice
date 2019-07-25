package com.practice.acm.ThreeLevel;

import com.practice.acm.IAlgorithm;

import java.util.Random;

/**快速排序,递归
 * Author: zhangshupeng
 * Date: 2019-07-25 10:36
 */
public class QuickSort implements IAlgorithm<int[]> {
    @Override
    public void process(int[] input) {

    }


    @Override
    public int[] getInput() {
        int[] input=new int[100];
        Random random=new Random();
        for (int i=0;i<100;i++){
            input[i]=random.nextInt(1000);
        }
        return input;
    }
}
