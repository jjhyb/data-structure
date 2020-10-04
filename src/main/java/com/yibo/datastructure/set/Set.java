package com.yibo.datastructure.set;

/**
 * @Author: huangyibo
 * @Date: 2020/9/231:47
 * @Description:
 */
public interface Set<E> {

    void add(E e);

    void remove(E e);

    boolean contains(E e);

    int getSize();

    boolean isEmpty();
}
