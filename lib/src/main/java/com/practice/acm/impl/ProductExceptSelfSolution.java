package com.practice.acm.impl;

public class ProductExceptSelfSolution {
    public int[] productExceptSelf(int[] nums) {
        if (nums==null||nums.length<=0){
            return null;
        }
        if (nums.length==1){
            return new int[1];
        }
        int[] answer =new int[nums.length];
        for (int i = nums.length-1; i >=0; i--) {//保留倒序相乘的结果
            if(i==nums.length-1){
                answer[i]=nums[i];
            }else{
                answer[i]=nums[i]*answer[i+1];
            }
        }
        for (int i = 0; i< nums.length; i++) {//保留正序相乘的结果
            if(i==0){
                nums[i]=nums[i];
            }else{
                nums[i]=nums[i-1]*nums[i];
            }
        }
        for (int i = 0; i< answer.length; i++) {
            if(i==0){
                answer[i]=answer[i+1];
            }else if(i== answer.length-1){
                answer[i]=nums[i-1];
            }else {
                answer[i]=answer[i+1]*nums[i-1];
            }
        }
        return answer;
    }
}