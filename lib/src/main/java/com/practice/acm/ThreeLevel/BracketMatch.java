package com.practice.acm.ThreeLevel;

import com.practice.acm.Base;

import java.util.Scanner;
import java.util.Stack;

/**
 * Author: zhangshupeng
 * Date: 17/7/12 下午7:17
 */

public class BracketMatch extends Base<String,Boolean> {
    @Override
    public Boolean process(String data) {
        Stack<Character> stack=new Stack<>();
        char[] chars=data.toCharArray();
        for (char c:chars){
            if (c=='('||c=='['||c=='{'){
                stack.push(c);
            }else if (c==')'||c==']'||c=='}'){
                //检测栈顶是否匹配
                if (!stack.empty()){
                    char top=stack.peek();
                    if(checkBracketMatch(top,c)){
                        stack.pop();
                    }else{
                        return  false;
                    }
                }
            }
        }
        if (stack.isEmpty())
            return true;
        return false;
    }

    @Override
    public void printResult(Boolean result) {
        System.out.println(result?"Yes":"No");
    }

    private boolean checkBracketMatch(char left, char right){
        switch (right){
            case ')':
                return left=='(';
            case ']':
                return left=='[';
            case '}':
                return left=='{';
        }
        return false;
    }
    @Override
    public String handleInput(Scanner scanner) {
        return scanner.nextLine();
    }
}
