package com.practice.acm.impl;

import java.util.ArrayList;
import java.util.List;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        List<Integer> startIndexs=new ArrayList<>();
        int startIndex=0;
        while (startIndex < gas.length) {
            int remain=0;
            for (int step = 0; step <gas.length ; step++) {
                int index = (startIndex + step)% gas.length;
                remain=remain+gas[index]-cost[index];
                if (remain<0){//不能移动到下一个加油站
                    startIndex=startIndex + step+1;
                    break;
                }else{
                    if (step==gas.length-1){//成功移动了一圈
                        return startIndex;
                    }
                }
            }
        }
        return -1;
    }
}
