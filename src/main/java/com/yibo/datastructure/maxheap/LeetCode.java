package com.yibo.datastructure.maxheap;

import java.util.LinkedList;
import java.util.TreeMap;

/**
 * @Author: huangyibo
 * @Date: 2020/9/2616:12
 * @Description:
 *
 * 347. 前 K 个高频元素
 *
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 *
 * 使用自己实现的PriorityQueue(最大堆)实现
 */
public class LeetCode {

    private class Freq implements Comparable<Freq>{
        int e, freq;

        public Freq(int e, int freq){
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq another) {
            if(this.freq < another.freq){
                return 1;
            }else if(this.freq > another.freq){
                return -1;
            }else{
                return 0;
            }
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        for (int num : nums) {
            if(treeMap.containsKey(num)){
                treeMap.put(num,treeMap.get(num) + 1);
            }else{
                treeMap.put(num,1);
            }
        }
        PriorityQueue<Freq> priorityQueue = new PriorityQueue<>();
        treeMap.forEach((key,value) -> {
            if (priorityQueue.getSize() < k) {
                priorityQueue.enQueue(new Freq(key,value));
            }else if(value > priorityQueue.getFront().freq){
                priorityQueue.deQueue();
                priorityQueue.enQueue(new Freq(key,value));
            }
        });
        LinkedList<Integer> linkedList = new LinkedList<>();
        while(!priorityQueue.isEmpty()){
            linkedList.add(priorityQueue.deQueue().e);
        }
        return linkedList.stream().mapToInt(Integer::valueOf).toArray();
    }
}
