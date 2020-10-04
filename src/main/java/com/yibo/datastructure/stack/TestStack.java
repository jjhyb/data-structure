package com.yibo.datastructure.stack;

import com.yibo.datastructure.queue.ArrayQueue;
import com.yibo.datastructure.queue.LoopQueue;
import com.yibo.datastructure.queue.Queue;

import java.util.Random;

/**
 * @Author: huangyibo
 * @Date: 2020/9/2018:25
 * @Description:
 */
public class TestStack {

    //测试使用queue运行opCount个enQueue和deQueue操作所需的时间，单位：秒
    private static double testStack(Stack<Integer> stack,int opCount){
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            stack.pop();
        }
        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int opCount = 100000;
        ArrayStack<Integer> arrayStack = new ArrayStack<Integer>();
        double time1 = testStack(arrayStack,opCount);
        System.out.println("ArrayStack, time: "+time1+" s");

        LinkedListStack<Integer> linkedListStack = new LinkedListStack<Integer>();
        double time2 = testStack(linkedListStack,opCount);
        System.out.println("LinkedListStack, time: "+time2+" s");
    }
}
