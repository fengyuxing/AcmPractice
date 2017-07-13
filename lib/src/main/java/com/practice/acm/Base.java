package com.practice.acm;

/**
 * Author: zhangshupeng
 * Date: 17/7/12 下午7:57
 */
public abstract class Base<I,O> implements IAlgorithm<I,O> {
    @Override
    public abstract O process(I data);

    @Override
    public void printResult(O result) {
        System.out.println(result);
    }
}
