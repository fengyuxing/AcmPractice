package com.practice.acm.impl;

public class RemoveDuplicateNum2 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        new Solution().removeDuplicates(nums);
    }

    static class Solution {
        public int removeDuplicates(int[] nums) {
            int start=0;int tail=nums.length;
            //遍历nums,
            while(start<tail){
                int value=nums[start];
                for(int step=0;start+step<tail;){
                    if(nums[start+step]!=value){
                        if(step>2){
                            //   moveLeft(nums,start+step,step-2);
                            for(int i=start+step;i<tail;i++){
                                nums[i-step+2]=nums[i];
                            }
                            start=start+2;
                            tail=tail-(step-2);
                        }else{
                            start=start+step;
                        }
                        break;
                    }else{
                        step++;
                        if (start+step==tail){
                            if(step>2){
                                tail=start+2;
                            }else{
                                tail=start+step;
                            }
                            start=tail;
                            break;
                        }
                    }
                }
            }
            return tail;
        }
    }
}
