package com.practice.acm.ThreeLevel;

import com.practice.acm.IAlgorithm;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * 单链表反转
 * Author: zhangshupeng
 * Date: 2019-07-24 18:31
 */
public class LinkListReverse implements IAlgorithm<List<Integer>> {

    @Override
    public void process(List<Integer> data) {

    }

    @Override
    public List<Integer> getInput() {
        List<Integer> list=new LinkedList<>();
        Random random=new Random();
        for (int i=0;i<5;i++) {
            list.add(random.nextInt(100));
        }
        return list;
    }
}
