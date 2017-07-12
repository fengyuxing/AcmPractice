package com.practice.acm;

import com.practice.acm.ThreeLevel.BracketMatch;

import java.util.Scanner;

public class Main {
    static IAlgorithm algorithm=new BracketMatch();
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int count=scanner.nextInt();
        scanner.nextLine();
        String[] testData=new String[count];
        for (int i=0;i<count;i++){
            testData[i]=scanner.nextLine();
            algorithm.printResult(algorithm.process(testData[i]));
        }
    }

}
