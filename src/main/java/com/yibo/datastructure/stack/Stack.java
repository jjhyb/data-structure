package com.yibo.datastructure.stack;

/**
 * @Author: huangyibo
 * @Date: 2020/9/2014:22
 * @Description:
 */
public interface Stack<E> {

    //栈的长度
    int getSize();

    //是否为空
    boolean isEmpty();

    //压栈
    void push(E e);

    //出栈
    E pop();

    //查看栈顶元素
    E peek();
}
