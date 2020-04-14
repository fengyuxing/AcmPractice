package com.practice.acm;

import com.practice.acm.impl.BinaryTreeNonRecursiveTraversal;
import com.practice.acm.impl.QuickSort;

public class Main {
    static IAlgorithm algorithm=new BinaryTreeNonRecursiveTraversal();
    public static void main(String[] args){
            algorithm.process(algorithm.getInput());
    }

}
