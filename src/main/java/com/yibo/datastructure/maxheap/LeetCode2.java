package com.yibo.datastructure.maxheap;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.PriorityQueue;

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
 * 使用JDK实现的PriorityQueue(最小堆)实现
 */
public class LeetCode2 {

    public int[] topKFrequent(int[] nums, int k) {
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        for (int num : nums) {
            if(treeMap.containsKey(num)){
                treeMap.put(num,treeMap.get(num) + 1);
            }else{
                treeMap.put(num,1);
            }
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(
                (a,b) -> treeMap.get(a) - treeMap.get(b)
        );
        treeMap.forEach((key,value) -> {
            if (priorityQueue.size() < k) {
                priorityQueue.add(key);
            }else if(value > treeMap.get(priorityQueue.peek())){
                priorityQueue.remove();
                priorityQueue.add(key);
            }
        });
        LinkedList<Integer> linkedList = new LinkedList<>();
        while(!priorityQueue.isEmpty()){
            linkedList.add(priorityQueue.remove());
        }
        return linkedList.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
        LeetCode2 leetCode2 = new LeetCode2();
        int[] nums = {1,1,1,2,2,3};
        int[] results = leetCode2.topKFrequent(nums, 2);
        for (int result : results) {
            System.out.println(result);
        }
    }
}
