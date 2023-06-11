package com.practice.acm.impl;

import static jdk.vm.ci.meta.JavaKind.Char;

import java.util.Scanner;
import java.util.Stack;

/**
 * 使用一个stack依次存放目录名字，
 * 1、消耗第一个字母，状态为根目录，入栈
 * 2、从第二个字母开始依次遍历，使用tempDir保存尚未解析完成的最后一级文件目录:
 * 2.1、遇到/，如果tempDir为空，直接消耗，如果tempDir不为空，将tempDir入栈且清空tempDir的值;
 * 2.2、遇到字母，append到目录名tempDir;
 * 2.3、遇到..,tempDir为空，stack出栈，如果tempDir不为空，append到目录名tempDir;
 * 2.4、遇到.,tempDir为空，直接消耗，如果tempDir不为空，append到目录名tempDir;
 * 路径最后，如果tempDir不为空，需要入栈。
 */
public class Problem2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
            String path = in.nextLine();
            Stack<String> stack=new Stack();
            String tempDir="";
        for (int i = 0; i < path.length(); i++) {
            char ch=path.charAt(i);
            switch (ch){
                case '/':
                    if ("".equals(tempDir)){//直接消耗,根目录也一样

                    }else{
                        stack.push(tempDir);
                        tempDir="";
                    }
                    break;
                case '.':
                    if (i+1<path.length()){
                        char nextCh=path.charAt(i+1);
                        if (nextCh=='.'){
                            if ("".equals(tempDir)){//
                                stack.pop();
                            }else{
                                tempDir+="..";
                            }
                            i++;
                        }else{
                            if ("".equals(tempDir)){

                            }else{
                                tempDir+=ch;
                            }
                        }
                    }else{
                        tempDir+=ch;
                    }
                   break;
                default://字母，此处不考虑非法
                    tempDir+=ch;
                    break;
            }
        }
        if (!"".equals(tempDir)){
            stack.push(tempDir);
        }
        String finalPath="";
        for (String s:stack){
            finalPath=s+"/"+finalPath;
        }

            System.out.println("/"+finalPath);
    }

}
