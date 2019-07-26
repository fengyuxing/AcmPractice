package com.practice.acm;

import com.practice.acm.ThreeLevel.QuickSort;

public class Main {
    static IAlgorithm algorithm=new QuickSort();
    public static void main(String[] args){
            algorithm.process(algorithm.getInput());
    }

}
