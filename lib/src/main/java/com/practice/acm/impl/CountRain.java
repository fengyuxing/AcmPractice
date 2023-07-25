package com.practice.acm.impl;

public class CountRain {
    public static void main(String[] args) {
        int[] height={4,2,3};
        System.out.println("result="+new CountRain().trap(height));
    }
    int total=0;
    int left=0,right=0;
    boolean isMovingLeft =true;
    public int trap(int[] height) {
        right=height.length-1;
        while (left< right) {
            if (isMovingLeft){
                moveLeft(height);
            }else{
                moveRight(height);
            }
        }
        return total;
    }

    private void moveLeft(int[] height) {
        if (height[right]>0){
            int tmp=findLeft(height, right);
            if (tmp>=0){
                //计算蓄水量
                total+=getRain(height,tmp,right);
                right=tmp;
                System.out.println("moveLeft="+tmp);
            }else{
                isMovingLeft=false;
                System.out.println("isMovingLeft="+false);
            }
        }else{
            right--;
        }
    }

    private void moveRight(int[] height) {
        if (height[left]>0){
            int tmp=findRight(height, left);
            if (tmp>=0){
                //计算蓄水量
                total+=getRain(height,left,tmp);
                left=tmp;
                System.out.println("moveRight="+tmp);
            }else{
                isMovingLeft=true;
                System.out.println("isMovingLeft="+true);
            }
        }else{
            left++;
        }
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
        for (int j = left +1; j <=right; j++) {//寻找右边柱子
            if(height[j]>= height[left]){
               return j;
            }
        }
        return -1;
    }

    private int findLeft(int[] height, int r) {
        for (int j = r -1; j >= left; j--) {//寻找左边柱子
            if(height[j]>= height[r]){
                return j;
            }
        }
        return -1;
    }
}
