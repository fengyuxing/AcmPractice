package com.practice.acm.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * leetcode 1061. 按字典序排列最小的等效字符串
 */
class SmallestEquivalentString {
    public static void main(String[] args){
       new SmallestEquivalentString().smallestEquivalentString("parker",
                "morris",
                "parser");
    }
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        // 1、创建一个以a到z为26个字母为key的map；
        // 2、遍历s1和s2的每个字符：
        // 如果两个字母都没有其他相等元素，new 一个set集合，把两个字母都加到中，存入第一步的map对象中;
        // 如果其中一个字母已经有相等元素，取出map对应的set集合，把另外一个加入到那个set中去;
        // 如果两个字母都已经有相等元素，把两个set集合合并成新的集合set，同时遍历新set中的每个元素，将它的map对应的set更新为新set;
        // 3、遍历map中的value，只保留字母序最小值;
        // 4、遍历baseStr的字母，找出map中保存的它的字母序最小值进行替换

        Map<Character , HashSet<Character>> map =new HashMap<>();
        for(int i=0;i<s1.length();i++){
            Character  ch1=s1.charAt(i);
            Character ch2=s2.charAt(i);
            HashSet<Character> set=new HashSet<>();
            HashSet<Character> set1=map.getOrDefault(ch1,new HashSet<>());
            HashSet<Character> set2=map.getOrDefault(ch2,new HashSet<>());
            set.add(ch1);
            set.add(ch2);
            set.addAll(set1);
            set.addAll(set2);
            for(Character ch:set){
                map.put(ch,set);
            }
        }

        Map<Character,Character> minOrderMap =new HashMap<>();
        for(Character ch:map.keySet()){
            HashSet<Character> valueSet= map.get(ch);
            if(valueSet!=null){
                Character minOrder='z'+1;
                for(Character v:valueSet){
                    if(v<minOrder){
                        minOrder=v;
                    }
                }
                minOrderMap.put(ch,minOrder);
            }
        }

        StringBuilder sb=new StringBuilder();
        for(int j=0;j<baseStr.length();j++){
            Character ch=baseStr.charAt(j);
            if(minOrderMap.get(ch)!=null){
                sb.append(minOrderMap.get(ch));
            }else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}