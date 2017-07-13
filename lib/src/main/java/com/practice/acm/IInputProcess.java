package com.practice.acm;

import java.util.Scanner;

/**
 * Author: zhangshupeng
 * Date: 17/7/13 下午3:16
 */

public interface IInputProcess<I> {
    I handleInput(Scanner scanner);
}
