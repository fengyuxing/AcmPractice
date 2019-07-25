package com.practice.acm.ThreeLevel;

import com.practice.acm.IAlgorithm;

import java.util.Stack;

/**
 * 判断括号是否匹配
 * Author: zhangshupeng
 * Date: 17/7/12 下午7:17
 */

public class BracketMatch implements IAlgorithm<String> {
    @Override
    public void process(String input) {
        boolean match=false;
        Stack<Character> stack=new Stack<>();
        char[] chars= input.toCharArray();
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
                        match=false;
                        break;
                    }
                }
            }
        }
        if (stack.isEmpty()) {
            match = true;
        }else {
            match = false;
        }
        System.out.println(match);
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
    public String getInput() {
        return "{{[]]}()()()}";
    }
}
