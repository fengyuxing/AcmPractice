package com.practice.acm;

import com.practice.acm.ThreeLevel.BracketMatch;

import java.util.Scanner;

public class Main {
    static IAlgorithm algorithm=new BracketMatch();
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int count=scanner.nextInt();
        scanner.nextLine();
        for (int i=0;i<count;i++){
            algorithm.printResult(algorithm.process(algorithm.handleInput(scanner)));
        }
    }

}
