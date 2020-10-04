package com.yibo.datastructure.queue;

import java.util.Random;

/**
 * @Author: huangyibo
 * @Date: 2020/9/2018:25
 * @Description:
 */
public class Test {

    //测试使用queue运行opCount个enQueue和deQueue操作所需的时间，单位：秒
    private static double testQueue(Queue<Integer> queue,int opCount){
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            queue.enQueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            queue.deQueue();
        }
        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int opCount = 100000;
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<Integer>();
        double time1 = testQueue(arrayQueue,opCount);
        System.out.println("ArrayQueue, time: "+time1+" s");

        LoopQueue<Integer> loopQueue = new LoopQueue<Integer>();
        double time2 = testQueue(loopQueue,opCount);
        System.out.println("LoopQueue, time: "+time2+" s");

        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<Integer>();
        double time3 = testQueue(linkedListQueue,opCount);
        System.out.println("LinkedListQueue, time: "+time3+" s");
    }
}
