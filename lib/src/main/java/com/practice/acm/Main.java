package com.practice.acm;

import com.practice.acm.ThreeLevel.BinaryStringMatch;

import java.util.Scanner;

public class Main {
    static IAlgorithm algorithm=new BinaryStringMatch();
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int count=scanner.nextInt();
        scanner.nextLine();
        for (int i=0;i<count;i++){
            algorithm.printResult(algorithm.process(algorithm.handleInput(scanner)));
        }
    }

}
