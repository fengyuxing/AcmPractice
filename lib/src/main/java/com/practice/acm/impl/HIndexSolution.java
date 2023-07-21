package com.practice.acm.impl;

import java.util.Random;

public class HIndexSolution {
    public static void main(String[] args) {
        int[] citations={1,3,1};
        new HIndexSolution().hIndex(citations);
    }
    public int hIndex(int[] citations) {
        //思路：数组按照引用次数进行原址排序（快排）
        sort(citations,0,citations.length);
        for(int i=0;i<citations.length;i++){
            if(citations[i]>=citations.length-i){
                return citations.length-i;
            }
        }
        return 0;
    }

    public void sort(int[] citations,int startIndex,int endIndex) {
        if(endIndex-startIndex<=1){
            return;
        }
        int base=citations[new Random().nextInt(endIndex-startIndex)+startIndex];
        int lt=startIndex;
        int i=startIndex;
        int gt =endIndex;
        while (i < gt) {
            if(citations[i]<base){
                swap(citations,lt,i);
                lt++;
                i++;
            }else if(citations[i]>base){
                swap(citations,gt-1,i);
                gt--;
            }else{
                i++;
            }
        }
        sort(citations,startIndex,lt);
        sort(citations,gt,endIndex);
    }

    private void swap(int[] citations, int i, int j) {
        int temp=citations[j];
        citations[j]=citations[i];
        citations[i]=temp;
    }
}
