package com.practice.acm;

/**
 * Author: zhangshupeng
 * Email: zhangshupeng@xywy.com
 * Date: 17/7/12 下午7:57
 */
interface IAlgorithm<R> {
    R process(String data);

    void printResult(R result);
}
