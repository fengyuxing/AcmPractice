package com.practice.acm.impl;

/**
 * 900. RLE 迭代器
 */
public class RLEIterator {
    int[] encoding;
    int currentIndex;
    int currentCost;
    public RLEIterator(int[] encoding) {
        this.encoding=encoding;
        currentIndex=0;
        currentCost=0;
    }

    public int next(int n) {
        if (currentIndex>=encoding.length){
            return -1;
        }
        int remain=encoding[currentIndex]-currentCost;
        if (remain>n){
            currentCost=currentCost+n;
            return encoding[currentIndex+1];
        }else if(remain==n){
            int num=encoding[currentIndex+1];
            currentIndex=currentIndex+2;
            currentCost=0;
            return num;
        }else{
            n=n-remain;
            currentIndex=currentIndex+2;
            currentCost=0;
            return next(n);
        }
    }
}
