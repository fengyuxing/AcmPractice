package com.practice.acm.impl;

import com.practice.acm.IAlgorithm;
import com.practice.acm.impl.BinaryTreeNonRecursiveTraversal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * 有序数组里面只有一个数重复了一次，找出它
 */
public class FindShowOnceNum implements IAlgorithm<int[]> {
    /**
     *
     * @param sortedArray
     * @param start  include
     * @param end  exclude
     */
    public  int findShowOnce(int[] sortedArray,int start,int end){
        if(start>=end||(end-start)%2==0)
            throw new RuntimeException("找不到符合条件的数字");
        if(start==end-1){
            return sortedArray[start];
        }
        // start end 边界检查
        int midIndex=(start+end)/2;
        if(sortedArray[midIndex]==sortedArray[midIndex-1]){//
            int size=midIndex-start+1;
            if(size%2==0){//左半部分数组长度是偶数,在右半部分找
                return findShowOnce(sortedArray,midIndex+1,end);
            }else{
                return findShowOnce(sortedArray,start,midIndex+1);
            }
        }else if(sortedArray[midIndex]==sortedArray[midIndex+1]){
            int size=end-midIndex;
            if(size%2==0){//右半部分数字长度是偶数，在左半部分找
                return findShowOnce(sortedArray,start,midIndex);
            }else{
                return findShowOnce(sortedArray,midIndex,end);
            }
        }else{
            return sortedArray[midIndex];
        }
    }

    @Override
    public void process(int[] nums) {
        if(nums==null)
            throw new RuntimeException("找不到符合条件的数字");
        int result= findShowOnce(nums,0,nums.length);
        System.out.println("realResult="+result);
    }

    @Override
    public int[] getInput() {
        List<Integer> list=new ArrayList<>();
        Random r=new Random();
        for(int i=0;i<20;i++){
           int val= r.nextInt(1000);
           list.add(val);
           list.add(val);
        }
        Integer expectedResult=list.remove(0);
        System.out.println("expectedResult="+expectedResult);
        int[] vals=new int[list.size()];
        for(int i=0;i<list.size();i++){
            vals[i]=list.get(i);
        }
        Arrays.sort(vals);
        return vals;
    }
}
