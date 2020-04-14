package com.practice.acm;

import com.practice.acm.impl.BinaryTreeNonRecursiveTraversal;
import com.practice.acm.impl.FindShowOnceNum;
import com.practice.acm.impl.QuickSort;

public class Main {
    static IAlgorithm algorithm=new FindShowOnceNum();
    public static void main(String[] args){
            algorithm.process(algorithm.getInput());
    }

}
