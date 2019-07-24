package com.practice.acm;

/**
 * Author: zhangshupeng
 * Date: 17/7/12 下午7:57
 */
public interface IAlgorithm<I> extends IInputProvider<I>{
    void process(I data);
}
