package com.yibo.datastructure.stack;

/**
 * @Author: huangyibo
 * @Date: 2020/9/2015:20
 * @Description:
 */
public class ArrayStackDemo1 {

    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<Integer>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }
}
