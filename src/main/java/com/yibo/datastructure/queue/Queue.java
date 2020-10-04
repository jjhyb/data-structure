package com.yibo.datastructure.queue;

/**
 * @Author: huangyibo
 * @Date: 2020/9/2016:36
 * @Description:
 */
public interface Queue<E> {

    //队列长度
    int getSize();

    //队列是否为空
    boolean isEmpty();

    //入队
    void enQueue(E e);

    //出队
    E deQueue();

    //获取队首的元素
    E getFront();
}
