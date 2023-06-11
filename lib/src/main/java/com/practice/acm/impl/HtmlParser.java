package com.practice.acm.impl;

/**
 * leetcode
 * 1410. HTML 实体解析器
 */
public class HtmlParser {
    public static void main(String[] args) {
        new HtmlParser().entityParser("and I quote: &quot;...&quot;");
    }
    public String entityParser(String text) {
        text=text.replaceAll("&quot;","\"");
        text=text.replaceAll("&apos;","'");
        text=text.replaceAll("&gt;",">");
        text=text.replaceAll("&lt;","<");
        text=text.replaceAll("&frasl;","/");
        text=text.replaceAll("&amp;","&");
        return text;
    }
}
