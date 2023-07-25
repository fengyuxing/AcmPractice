package com.practice.acm.impl;

public class DeliverCandy {
    public int candy(int[] ratings) {
        //使用c[]记录每个孩子应该分到的糖果数，假设c[0]为1,如果r[1]>r[0],c[1]=2;如果r[1]==r[0],c[1]=1;如果r[1]<r[0],c[1]=1,同时修改c[0]为2;
        int[] c=new int[ratings.length];
        c[0]=1;
        for (int i = 1; i < ratings.length; i++) {
            //assighRightByLeft();
            decideRightByLeft(ratings, c, i);
        }
        int total=0;
        for (int i = 0; i < ratings.length; i++) {
           total+=c[i];
        }
        return total;
    }

    private void decideRightByLeft(int[] ratings, int[] c, int r) {
        if (ratings[r]> ratings[r -1]){
            c[r]= c[r -1]+1;
        }else if(ratings[r]< ratings[r -1]){
            int temp= c[r -1]-1;
            c[r]=1;
            if (temp<1){
                adjustLeftByRight(ratings, c, r);
            }
        }else{
            c[r]=1;
        }
    }

    private void adjustLeftByRight(int[] ratings, int[] c, int r) {
        if (r-1<0)
            return;
        if (ratings[r]< ratings[r -1]){
            if(c[r-1]==c[r]){
                c[r-1]=c[r]+1;
                adjustLeftByRight(ratings, c, r-1);
            }
        }
    }

}
