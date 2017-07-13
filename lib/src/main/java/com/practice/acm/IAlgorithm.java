package com.practice.acm;

/**
 * Author: zhangshupeng
 * Date: 17/7/12 下午7:57
 */
interface IAlgorithm<I,R> extends IInputProcess<I>,IOutputProcess<R>{
    R process(I data);
}
