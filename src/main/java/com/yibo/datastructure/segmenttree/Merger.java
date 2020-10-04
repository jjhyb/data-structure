package com.yibo.datastructure.segmenttree;

/**
 * @Author: huangyibo
 * @Date: 2020/9/270:48
 * @Description:
 */
public interface Merger<E> {

    E merge(E a, E b);
}
