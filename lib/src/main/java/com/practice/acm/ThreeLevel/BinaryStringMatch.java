package com.practice.acm.ThreeLevel;

import com.practice.acm.IAlgorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 查找一个字符串在另一个字符串中出现次数
 * Author: zhangshupeng
 * Date: 17/7/14 下午7:36
 * 问题描述
 * Given two strings A and B, whose alphabet consist only ‘0’ and ‘1’. Your task is only to tell how many times does A appear as a substring of B? For example, the text string B is ‘1001110110’ while the pattern string A is ‘11’, you should output 3, because the pattern A appeared at the posit
 * 遍历处理，可考虑在不等处求最长后缀跳过部分str，再优化
 */

public class BinaryStringMatch implements IAlgorithm<List<String>> {
    @Override
    public List<String> getInput() {
        List<String> list=new ArrayList<>();
        list.add("asadasdadasdasda");
        list.add("asadasdadasdasdaasadasdadadadasdadaasdad");
        return list;
    }

    @Override
    public void process(List<String> data) {
        char[] shotStr =data.get(0).toCharArray();
        char[] longStr =data.get(1).toCharArray();
        int matchCount=0;
        for (int i = 0; i< longStr.length; i++){
            boolean isMatch=true;
            int index=i;
            for (int j = 0; j< shotStr.length; j++){
                if (shotStr[j]!= longStr[index]){
                    isMatch=false;
                    break;
                }else{
                    if (index<longStr.length-1){
                        index++;
                    }else{
                        isMatch=false;
                        break;
                    }
                }
            }
            if (isMatch)
                matchCount++;
        }
        System.out.println(matchCount);
    }

}
