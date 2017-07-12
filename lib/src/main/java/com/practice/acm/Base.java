package com.practice.acm;

/**
 * Author: zhangshupeng
 * Email: zhangshupeng@xywy.com
 * Date: 17/7/12 下午7:57
 */
public abstract class Base<R> implements IAlgorithm<R> {
    @Override
    public abstract R process(String data);

    @Override
    public void printResult(R result) {
        System.out.println(result);
    }
}
