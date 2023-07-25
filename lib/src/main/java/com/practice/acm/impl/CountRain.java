package com.practice.acm.impl;

public class CountRain {
    public static void main(String[] args) {
        int[] height={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("result="+new CountRain().trap(height));
    }
    public int trap(int[] height) {
        int left=0,right=0;
        int total=0;
        while (left< height.length) {
            if (height[left]>0){
                right=findRight(height, left);
                if (right>0){
                    //计算蓄水量
                    total+=getRain(height,left,right);
                    left=right;
                    System.out.println("left="+right);
                }else{
                    break;
                }
            }else{
                left++;
                System.out.println("left+1");
            }
        }
        return total;
    }

    private int getRain(int[] height, int left, int right) {
        int rain=0;
        int maxHeight=Math.min(height[left],height[right]);
        for (int i = left+1; i <right; i++) {
            rain+=maxHeight-height[i];
            System.out.println("getRain");
        }
        return rain;
    }

    private int findRight(int[] height, int left) {
        int maxRightHeightIndex=0;
        int maxRightHeight=0;
        for (int j = left +1; j < height.length; j++) {//寻找右边柱子
            if(height[j]>= height[left]){
               return j;
            }else{
                if (height[j]>=maxRightHeight){
                    maxRightHeight= height[j];
                    maxRightHeightIndex=j;
                }
            }
            System.out.println("findRight");
        }
        if (maxRightHeight>0)
            return maxRightHeightIndex;
        return -1;
    }
}
