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
        printArray(input);
        int start=0;
        int end=input.length-1;
        sort(input,start,end);
        printArray(input);
    }
    private  void printArray(int[] input){
        String s="";
        for (int i:input){
            s=s+i+"  ";
        }
        System.out.println(s);
    }

    private void sort(int[] input,int start,int end){
        if (start>=end-1)
            return;
        Random random=new Random();
        int index=random.nextInt(end-start)+start;
        int compareValue=input[index];
        int left=start;
        int right=end;

        while (left<right){//一次遍历分割成两个小数组
            int current=input[left];
            if (current<compareValue){
                left++;
            }else{
                current=input[right];
                input[right]=input[left];
                input[left]=current;
                right--;
            }
        }
        System.out.println("start="+start+",left="+left+"end="+end);
        sort(input,start,left);
        sort(input,right,end);
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
